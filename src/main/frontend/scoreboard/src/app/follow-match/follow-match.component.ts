import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {MatchService} from "../common/match.service";
import {MatchResponse} from "../common/MatchResponse";
import {MatchWsService} from "../common/matchws.service";

@Component({
  selector: 'app-follow-match',
  templateUrl: './follow-match.component.html',
  styleUrls: ['./follow-match.component.scss']
})
export class FollowMatchComponent implements OnInit {

  match:MatchResponse;

  constructor(private route: ActivatedRoute
    , private matchService:MatchService
    , private matchWsService:MatchWsService) { }

  ngOnInit() {
    this.route.params.subscribe((param: Params) => {
      if(param){
        let matchId = param["matchId"];
        this.matchWsService.connect(matchId,
          (match)=>{ this.match = JSON.parse(match.body);
        });
        this.matchService.matchDetails(matchId).subscribe((data:MatchResponse) => {
          this.match = data;

        });
      }
    });
  }

  disconnect() {
    this.matchWsService.disconnect();
  }

  isConnected():boolean {
    return this.matchWsService.isConnected();
  }

}
