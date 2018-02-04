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
      console.log("connection..." , data);
      this.matchDetail = data;
    });
    matchWsService.connect(this.matchId, (matchDetail)=>{
     // console.log("score", newScore.body)
      this.matchDetail = JSON.parse(matchDetail.body)
    });
  }

  ngOnInit() {
  }

  public addPoints(points:number) {
    // this.matchService.addPoints(points).subscribe((data:CurrentFrameResponse)=>{
    //   this.currentFrame = data;
    // });

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

  isConnected():boolean {
    return this.matchWsService.isConnected();
  }


}
