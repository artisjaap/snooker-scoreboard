import { Injectable} from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {environment} from "../../environments/environment";



@Injectable()
export class MatchWsService {
  private serverUrl = environment.wsEndpoint;
  private stompClient;

  constructor(){
    this.initializeWebSocketConnection();

  }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);

  }

  connect(matchId:number, funct:any) {
    this.stompClient.connect({}, (frame) => {
      this.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
     });
  }

  disconnect() {
    this.stompClient.disconnect();
  }

  addPoints(points, matchId){
    this.sendMessage(matchId, {action : "ADD_POINTS", matchId : matchId, points : points});
  }

  addFault(points, matchId){
    this.sendMessage(matchId, {action : "ADD_FAULT", matchId : matchId, points : points});
  }

  changeTurn( matchId){
    this.sendMessage(matchId, {action : "CHANGE_TURN", matchId : matchId});
  }

  startNewFrame(matchId) {
    this.sendMessage(matchId, {action : "START_NEW_FRAME", matchId : matchId});
  }

  forceScoreForPlayer(matchId, player, points) {
    this.sendMessage(matchId, {action : "MANUAL_CORRECT_SCORE", matchId : matchId, player:player, points:points});
  }

  correctRemaining(matchId, points) {
    this.sendMessage(matchId, {action : "MANUAL_CORRECT_REMAINING", matchId : matchId, points:points});
  }

  private sendMessage(matchId, message){
    this.stompClient.send("/app/match/" + matchId , {}, JSON.stringify(message));
  }

  isConnected() : boolean{
    // return false;
    return this.stompClient.connected;
  }



}
