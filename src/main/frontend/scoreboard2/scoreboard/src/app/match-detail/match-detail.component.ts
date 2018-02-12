import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {MatchService} from "../../../../../scoreboard/src/app/common/match.service";

@Component({
  selector: 'app-match-detail',
  templateUrl: './match-detail.component.html',
  styleUrls: ['./match-detail.component.css']
})
export class MatchDetailComponent implements OnInit {

  matchDetails: any;

  constructor(private route: ActivatedRoute
    , private matchService:MatchService) { }

  ngOnInit() {
    // this.route.params.subscribe((param: Params) => {
    //   if(param){
    //     let matchId = param["matchId"];
    //     this.matchService.matchDetails(matchId).subscribe((data:any) => {
    //       this.matchDetails = data;
    //
    //     });
    //   }
    // });
  }

}
