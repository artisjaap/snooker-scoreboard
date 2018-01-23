import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {MatchService} from "../common/match.service";
import {MatchResponse} from "../common/MatchResponse";

@Component({
  selector: 'app-follow-match',
  templateUrl: './follow-match.component.html',
  styleUrls: ['./follow-match.component.css']
})
export class FollowMatchComponent implements OnInit {

  match:MatchResponse;

  constructor(private route: ActivatedRoute, private matchService:MatchService) { }

  ngOnInit() {
    this.route.params.subscribe((param: Params) => {
      let matchId = param["matchId"];
      this.matchService.matchDetails(matchId).subscribe((data:MatchResponse) => {
        this.match = data;
      });
    });
  }

}
