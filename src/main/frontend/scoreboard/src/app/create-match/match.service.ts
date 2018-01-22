import { Injectable } from '@angular/core';
import {CustomHttpService} from "../common/custom-http.service";
import {Observable} from "rxjs";
import {MatchRequestTO} from "./MatchRequestTO";

@Injectable()
export class MatchService {

  constructor(private customHttp:CustomHttpService) {

  }

  public createMatch(match:MatchRequestTO):Observable<any>{
    return this.customHttp.postJson("public/api/match/new", match);
  }

}
