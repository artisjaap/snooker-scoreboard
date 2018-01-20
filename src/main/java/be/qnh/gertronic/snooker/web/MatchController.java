package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.*;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.web.request.NewMatchRequest;
import be.qnh.gertronic.snooker.web.response.CurrentFrameResponse;
import be.qnh.gertronic.snooker.web.response.MatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stijn on 19/01/18.
 */
@RestController
public class MatchController {

    @Autowired
    private CreateMatch createMatch;

    @Autowired
    private MatchSummary matchSummary;

    @Autowired
    private StartNewGame startNewGame;

    @Autowired
    private ChangeTurn changeTurn;

    @Autowired
    private AddPoints addPoints;

    @RequestMapping(value = "api/match/new", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<MatchResponse> newMatch(@RequestBody NewMatchRequest newMatchRequest){
        MatchSummaryTO summaryTO = createMatch.voor(newMatchRequest.convertToTO());
        startNewGame.forMatch(summaryTO.matchId());
        return ResponseEntity.ok(MatchResponse.from(summaryTO));
    }

    @RequestMapping(value = "api/match/{matchId}/new-frame", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<CurrentFrameResponse> newFrame(@PathVariable Integer matchId){
        startNewGame.forMatch(matchId);
        return currentFrameForMatchMatchAsResponse(matchId);
    }

    private ResponseEntity<CurrentFrameResponse> currentFrameForMatchMatchAsResponse(@PathVariable Integer matchId) {
        MatchSummaryTO summaryTO = matchSummary.forMatch(matchId);
        return ResponseEntity.ok(CurrentFrameResponse.from(summaryTO.currentFrame()));
    }

    @RequestMapping(value = "api/match/{matchId}/change-turn", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<CurrentFrameResponse> changeTurn(@PathVariable Integer matchId){
        changeTurn.onMatch(matchId);
        return currentFrameForMatchMatchAsResponse(matchId);
    }

    @RequestMapping(value = "api/match/{matchId}/add-points/{points}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<CurrentFrameResponse> addPoints(@PathVariable Integer matchId, @PathVariable Integer points){
        addPoints.toMatch(matchId, points);
        return currentFrameForMatchMatchAsResponse(matchId);
    }


}
