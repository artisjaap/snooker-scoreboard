import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {MatchService} from "../common/match.service";
import {NewMatchResponse} from "../common/NewMatchResponse";

@Component({
  selector: 'app-remote-control-connect',
  templateUrl: './remote-control-connect.component.html',
  styleUrls: ['./remote-control-connect.component.css']
})
export class RemoteControlConnectComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router:Router, private matchService:MatchService) {
    this.route.params.subscribe((param: Params) => {
      let username = param["username"];
      let password = param["password"];
      matchService.loginWith(username, password).subscribe((data:NewMatchResponse) => {
        if(data.matchId){
          this.router.navigate(['/remote-control']);
        }
      });
    });
  }

  ngOnInit() {
  }

}
