package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.AddPoints;
import be.qnh.gertronic.snooker.action.ChangeTurn;
import be.qnh.gertronic.snooker.action.MatchSummary;
import be.qnh.gertronic.snooker.action.StartNewGame;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.security.SecurityUtils;
import be.qnh.gertronic.snooker.web.response.CurrentFrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stijn on 19/01/18.
 */
@RestController
@RequestMapping("/secure")
public class MatchController {
    @Autowired
    private MatchSummary matchSummary;

    @Autowired
    private StartNewGame startNewGame;

    @Autowired
    private ChangeTurn changeTurn;

    @Autowired
    private AddPoints addPoints;

    @RequestMapping(value = "/api/match/{matchId}/new-frame", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<CurrentFrameResponse> newFrame(@PathVariable Integer matchId){
        checkIfAuthenticatedForMatch(matchId);
        startNewGame.forMatch(matchId);
        return currentFrameForMatchMatchAsResponse(matchId);
    }

    @RequestMapping(value = "/api/match/{matchId}/change-turn", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<CurrentFrameResponse> changeTurn(@PathVariable Integer matchId){
        checkIfAuthenticatedForMatch(matchId);
        changeTurn.onMatch(matchId);
        return currentFrameForMatchMatchAsResponse(matchId);
    }

    @RequestMapping(value = "/api/match/{matchId}/add-points/{points}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<CurrentFrameResponse> addPoints(@PathVariable Integer matchId, @PathVariable Integer points){
        checkIfAuthenticatedForMatch(matchId);
        addPoints.toMatch(matchId, points);
        return currentFrameForMatchMatchAsResponse(matchId);
    }

    private void checkIfAuthenticatedForMatch(Integer matchId) {
        SecurityUtils.findSessionData()
                .filter(matchDetails -> matchDetails.getMatchId().equals(matchId))
                .orElseThrow(() -> new AuthorizationServiceException("Not authorized to change the match") );
    }

    private ResponseEntity<CurrentFrameResponse> currentFrameForMatchMatchAsResponse(@PathVariable Integer matchId) {

        MatchSummaryTO summaryTO = matchSummary.forMatch(matchId);
        return ResponseEntity.ok(CurrentFrameResponse.from(summaryTO.currentFrame()));
    }

}
