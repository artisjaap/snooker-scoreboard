import {Inject, Injectable} from '@angular/core';
import {CustomHttpService} from "./custom-http.service";
import {BehaviorSubject, Observable} from "rxjs";
import {MatchRequestTO} from "../create-match/MatchRequestTO";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MatchResponse} from "./MatchResponse";
import {NewMatchResponse} from "./NewMatchResponse";
import {CurrentFrameResponse} from "./CurrentFrameResponse";

@Injectable()
export class MatchService {

  private jwtToken: string;
  private matchId: number;

  constructor(private httpClient:HttpClient, @Inject('API_URL') private apiUrl: string) {
    console.log("create service");
  }

  public createMatch(match:MatchRequestTO):Observable<NewMatchResponse>{
    let subject:BehaviorSubject<NewMatchResponse> = new BehaviorSubject(new NewMatchResponse());

    //FIXME there are two subscribers on this post request
    //one here and one in the createMatchComponent
    //this is causing the post to fire two request to the server (one for each subscriber)
    //useing a BehaviorSubject solves this but isnt the best solution
    let post:Observable<NewMatchResponse> = this.httpClient.post<NewMatchResponse>(this.apiUrl + "public/api/match/new", match);
    post.subscribe((response:NewMatchResponse) => {
      this.jwtToken = "Bearer " + response.jwtToken;
      this.matchId = response.matchId;
      subject.next(response);
    });

    return subject.asObservable();
  }

  public matchDetails(matchId:number):Observable<MatchResponse>{
    return this.httpClient.get<MatchResponse>(this.apiUrl + "public/api/match/" + matchId);
  }

  public changeTurn():Observable<CurrentFrameResponse>{
    return this.httpClient.put<CurrentFrameResponse>(this.apiUrl + "secure//api/match/"+ this.matchId +"/change-turn"
      , {}
      , {headers: {'Authorization': this.jwtToken}}
    );
  }

  public addPoints(points:number):Observable<CurrentFrameResponse>{

    return this.httpClient.put<CurrentFrameResponse>(this.apiUrl + "secure/api/match/"+ this.matchId +"/add-points/" + points
      , {}
      , {headers: {'Authorization': this.jwtToken}}
      );
  }

  public newFrame():Observable<CurrentFrameResponse>{
    return this.httpClient.put<CurrentFrameResponse>(this.apiUrl + "/secure/api/match/"+ this.matchId +"/new-frame"
      , {}
      , {headers: {'Authorization': this.jwtToken}}
    );
  }

  public curentMatchId(): number{
    return this.matchId;
  }

  public loginWith(username:string, password:string) : Observable<any>{
    let subject:BehaviorSubject<NewMatchResponse> = new BehaviorSubject(new NewMatchResponse());

    this.httpClient.get(this.apiUrl + "/public/api/login/" + username + "/" + password)
      .subscribe((response:NewMatchResponse) => {
        this.jwtToken = "Bearer " + response.jwtToken;
        this.matchId = response.matchId;
        subject.next(response);
    });

    return subject.asObservable();
  }



}
