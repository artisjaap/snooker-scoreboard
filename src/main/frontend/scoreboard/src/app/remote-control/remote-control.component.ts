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

  constructor(private matchService:MatchService, private matchWsService:MatchWsService) {
    this.matchId = matchService.curentMatchId();
    matchWsService.connect(this.matchId, ()=>{});
  }

  ngOnInit() {
  }

  public addPoints(points:number) {
    console.log("hello");
    // this.matchService.addPoints(points).subscribe((data:CurrentFrameResponse)=>{
    //   this.currentFrame = data;
    // });

    this.matchWsService.sendMessage(points, this.matchId);
  }

  public changeTurn() {
    this.matchService.changeTurn().subscribe((data:CurrentFrameResponse)=>{
      this.currentFrame = data;
    });
  }

  public newFrame() {
    this.matchService.newFrame().subscribe((data:CurrentFrameResponse)=>{
      this.currentFrame = data;
    });
  }

}
