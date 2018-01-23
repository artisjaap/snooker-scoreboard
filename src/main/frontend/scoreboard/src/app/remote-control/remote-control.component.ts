import { Component, OnInit } from '@angular/core';
import {MatchService} from "../common/match.service";
import {CurrentFrameResponse} from "../common/CurrentFrameResponse";

@Component({
  selector: 'app-remote-control',
  templateUrl: './remote-control.component.html',
  styleUrls: ['./remote-control.component.scss']
})
export class RemoteControlComponent implements OnInit {
  currentFrame: CurrentFrameResponse;
  matchId:number;

  constructor(private matchService:MatchService) {
    this.matchId = matchService.curentMatchId();
  }

  ngOnInit() {
  }

  public addPoints(points:number) {
    this.matchService.addPoints(points).subscribe((data:CurrentFrameResponse)=>{
      this.currentFrame = data;
    });
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
