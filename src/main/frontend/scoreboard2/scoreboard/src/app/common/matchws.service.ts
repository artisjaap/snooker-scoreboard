import { Injectable} from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import {environment} from "../../environments/environment";



@Injectable()
export class MatchWsService {
  private serverUrl = environment.wsEndpoint;
  private stompClient;

  constructor(){
    //this.initializeWebSocketConnection();

  }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    console.log("initialized");


  }

  connect(matchId:number, funct:any) {
    console.log("connect");
    // this.stompClient.connect({}, (frame) => {
    //   this.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
    //  });
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

  private sendMessage(matchId, message){
    this.stompClient.send("/app/match/" + matchId , {}, JSON.stringify(message));
  }

  isConnected() : boolean{
    return false;
    //return this.stompClient.connected;
  }



}
