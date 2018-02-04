import {PlayerResponse} from "./PlayerResponse";
import {CurrentFrameResponse} from "./CurrentFrameResponse";
/**
 * Created by stijn on 22/01/18.
 */
export class MatchResponse {
  matchId:number;
  player1:PlayerResponse;
  player2:PlayerResponse;
  framesWonPlayer1:number;
  framesWonPlayer2:number;
  highestBreakPlayer1:number;
  highestBreakPlayer2:number;
  currentFrame:CurrentFrameResponse;
}
