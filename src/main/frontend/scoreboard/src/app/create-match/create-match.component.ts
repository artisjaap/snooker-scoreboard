import { Component, OnInit } from '@angular/core';
import {MatchService} from "../common/match.service";
import {MatchRequestTO} from "./MatchRequestTO";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-match',
  templateUrl: './create-match.component.html',
  styleUrls: ['./create-match.component.scss']
})
export class CreateMatchComponent implements OnInit {
  matchForm: FormGroup;

  constructor(private matchService:MatchService, private router:Router, private route:ActivatedRoute) {
    this.matchForm = new FormGroup({
      firstNamePlayer1 : new FormControl('', Validators.required),
      lastNamePlayer1 : new FormControl('', Validators.required),
      firstNamePlayer2 : new FormControl('', Validators.required),
      lastNamePlayer2 : new FormControl('', Validators.required),
      numberOfFrames : new FormControl('', Validators.required),
    });

  }

  ngOnInit() {
  }

  public createMatch(){

    if(this.matchForm.valid){
     this.matchService.createMatch(this.matchForm.value).subscribe((data) => {
       console.log("subscribe on match", data);
       if(data.matchId){
        this.router.navigate(['../follow-match/', data.matchId], {relativeTo:this.route});
       }
     });
    }
  }


}
