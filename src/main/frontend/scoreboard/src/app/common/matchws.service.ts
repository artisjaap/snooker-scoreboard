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

  }

  connect(matchId:number, funct:any) {
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
    });
  }

  sendMessage(points, matchId){
    this.stompClient.send("/app/match/" + matchId , {}, JSON.stringify({points:points, matchId:matchId}));

  }
}
