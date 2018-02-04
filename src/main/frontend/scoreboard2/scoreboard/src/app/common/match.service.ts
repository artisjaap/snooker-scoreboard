import {Inject, Injectable} from '@angular/core';
import {CustomHttpService} from "./custom-http.service";
import {BehaviorSubject, Observable} from "rxjs";
import {MatchRequestTO} from "../create-match/MatchRequestTO";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MatchResponse} from "./MatchResponse";
import {NewMatchResponse} from "./NewMatchResponse";
import {CurrentFrameResponse} from "./CurrentFrameResponse";
import {environment} from "../../environments/environment";


@Injectable()
export class MatchService {
  private matchData = {jwtToken: "", matchId: 0, username:"", password:""};
  private apiUrl = environment.serverUrl;

  constructor(private httpClient:HttpClient) {
    this.resetTokenFromLocalStorage();
  }

  private resetTokenFromLocalStorage(){
    let storedMatch = localStorage.getItem("match");
    if(storedMatch){
      this.matchData = JSON.parse(storedMatch);
    }
  }

  public createMatch(match:MatchRequestTO):Observable<NewMatchResponse>{
    let subject:BehaviorSubject<NewMatchResponse> = new BehaviorSubject(new NewMatchResponse());

    //FIXME there are two subscribers on this post request
    //one here and one in the createMatchComponent
    //this is causing the post to fire two request to the server (one for each subscriber)
    //useing a BehaviorSubject solves this but isnt the best solution
    let post:Observable<NewMatchResponse> = this.httpClient.post<NewMatchResponse>(this.apiUrl + "public/api/match/new", match);
    post.subscribe((response:NewMatchResponse) => {
      this.matchData.jwtToken = "Bearer " + response.jwtToken;
      this.matchData.matchId = response.matchId;
      this.matchData.username = response.username;
      this.matchData.password = response.password;

      localStorage.setItem("match", JSON.stringify(this.matchData));
      subject.next(response);
    });

    return subject.asObservable();
  }

  public generateRemoteConnectUrl():string{
    return window.location.protocol + "//" +
      window.location.hostname +
      ":" + window.location.port +
      "/remote-connect/" + this.matchData.username + "/" + this.matchData.password;
  }

  public matchDetails(matchId:number):Observable<MatchResponse>{
    return this.httpClient.get<MatchResponse>(this.apiUrl + "public/api/match/" + matchId);
  }

  public changeTurn():Observable<CurrentFrameResponse>{
    return this.httpClient.put<CurrentFrameResponse>(this.apiUrl + "secure/api/match/"+ this.matchData.matchId +"/change-turn"
      , {}
      , {headers: {'Authorization': this.matchData.jwtToken}}
    );
  }

  public addPoints(points:number):Observable<CurrentFrameResponse>{

    return this.httpClient.put<CurrentFrameResponse>(this.apiUrl + "secure/api/match/"+ this.matchData.matchId +"/add-points/" + points
      , {}
      , {headers: {'Authorization': this.matchData.jwtToken}}
      );
  }

  public newFrame():Observable<CurrentFrameResponse>{
    return this.httpClient.put<CurrentFrameResponse>(this.apiUrl + "secure/api/match/"+ this.matchData.matchId +"/new-frame"
      , {}
      , {headers: {'Authorization': this.matchData.jwtToken}}
    );
  }

  public curentMatchId(): number{
    return this.matchData.matchId;
  }

  public loginWith(username:string, password:string) : Observable<any>{
    let subject:BehaviorSubject<NewMatchResponse> = new BehaviorSubject(new NewMatchResponse());

    this.httpClient.get(this.apiUrl + "public/api/login/" + username + "/" + password)
      .subscribe((response:NewMatchResponse) => {
        this.matchData.jwtToken = "Bearer " + response.jwtToken;
        this.matchData.matchId = response.matchId;
        subject.next(response);
    });

    return subject.asObservable();
  }



}
