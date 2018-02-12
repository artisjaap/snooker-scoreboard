import { Component, OnInit } from '@angular/core';
import {MatchService} from "../common/match.service";
import {CurrentFrameResponse} from "../common/CurrentFrameResponse";
import {MatchWsService} from "../common/matchws.service";

@Component({
  selector: 'app-remote-control',
  templateUrl: './remote-control.component.html',
  styleUrls: ['./remote-control.component.scss']
})
export class RemoteControlComponent implements OnInit {
  currentFrame: CurrentFrameResponse;
  matchId:number;
  matchDetail: any;
  mode: string = 'NORMAL';


  constructor(private matchService:MatchService, private matchWsService:MatchWsService) {
    this.matchId = matchService.curentMatchId();
    matchService.matchDetails(this.matchId).subscribe((data)=>{
      this.matchDetail = data;
    });

  }

  ngOnInit() {
    this.matchWsService.connect(this.matchId, (matchDetail)=>{
      this.matchDetail = JSON.parse(matchDetail.body)
    });
  }

  public addPoints(points:number) {


    this.matchWsService.addPoints(points, this.matchId);
  }

  public addFault(points:number) {
    // this.matchService.addPoints(points).subscribe((data:CurrentFrameResponse)=>{
    //   this.currentFrame = data;
    // });

    this.matchWsService.addFault(points, this.matchId);
    this.mode = 'NORMAL';
  }



  public changeTurn() {
    this.matchWsService.changeTurn(this.matchId);
  }

  public newFrame() {
    this.matchWsService.startNewFrame(this.matchId);
  }

  public faultMode() {
    this.mode = 'ERROR';
  }

  public normalMode() {
    this.mode = 'NORMAL';
  }

  public correctingMode() {
    this.mode = 'CORRECTING';
  }

  isConnected():boolean {
    return this.matchWsService.isConnected();
  }

  // new component>>>

  public activePlayer:number = 1;
  setActivePlayer(player:number){
    this.activePlayer = player;
    console.log(this.activePlayer)
  }

  public appendScore(score:number){
    if(this.activePlayer == 1){
      this.matchDetail.currentFrame.scorePlayer1 *= 10;
      this.matchDetail.currentFrame.scorePlayer1 += score;
    }else {
      this.matchDetail.currentFrame.scorePlayer2 *= 10;
      this.matchDetail.currentFrame.scorePlayer2 += score;
    }
  }

  clearScore(score:number){
    if(this.activePlayer == 1){
      this.matchDetail.currentFrame.scorePlayer1 = 0;
    }else {
      this.matchDetail.currentFrame.scorePlayer2 = 0;

    }
  }

  correctRemaining(points:number) {
    this.matchWsService.correctRemaining(this.matchId, points);
  }

  saveScores(score:number){
    this.matchWsService.forceScoreForPlayer(this.matchId, 1, this.matchDetail.currentFrame.scorePlayer1);
    this.matchWsService.forceScoreForPlayer(this.matchId, 2, this.matchDetail.currentFrame.scorePlayer2);
    this.mode = 'NORMAL';
  }
}
