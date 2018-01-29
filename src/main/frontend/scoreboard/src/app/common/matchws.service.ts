import {Inject, Injectable} from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Injectable()
export class MatchWsService {
  private serverUrl = 'http://localhost:8080/matchsocket'
  private stompClient;

  constructor(){
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    console.log("initialized");

  }

  connect(matchId:number, funct:any) {
    console.log("connect");
    // let that = this;
    // this.stompClient.connect({}, function(frame) {
    //   that.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
    // });
    this.stompClient.connect({}, (frame) => {
      this.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
     });

  }

  disconnect() {
    this.stompClient.disconnect();
  }

  sendMessage(points, matchId){
    this.stompClient.send("/app/match/" + matchId , {}, JSON.stringify({points:points, matchId:matchId}));
  }

  isConnected() : boolean{
    return this.stompClient.connected;
  }


}
