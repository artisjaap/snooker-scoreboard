import {PlayerResponse} from "./PlayerResponse";
/**
 * Created by stijn on 22/01/18.
 */
export class NewMatchResponse {
  matchId:number;
  player1:PlayerResponse;
  player2:PlayerResponse;
  username:string;
  password:string;
  jwtToken:string;
}
