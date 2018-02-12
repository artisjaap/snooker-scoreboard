package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.*;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.web.request.MatchUpdateRequest;
import be.qnh.gertronic.snooker.web.response.MatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MatchWsController {

    @Autowired
    private AddPoints addPoints;

    @Autowired
    private ChangeTurn changeTurn;

    @Autowired
    private StartNewGame startNewGame;

    @Autowired
    private AddFault addFault;

    @Autowired
    private ManualCorrectionPlayerscore manualCorrectionPlayerscore;

    @Autowired
    private ManualCorrectionRemaining manualCorrectionRemaining;

    @MessageMapping("/match/{matchId}")
    @SendTo("/topic/currentframe/{matchId}")
    public MatchResponse processMessage(MatchUpdateRequest request) throws Exception {
        switch (request.getAction()){
            case ADD_POINTS: return doAddPoints(request.getMatchId(), request.getPoints());
            case CHANGE_TURN: return doChangeTurn(request.getMatchId());
            case START_NEW_FRAME: return doStartNewGame(request.getMatchId());
            case ADD_FAULT: return doAddFault(request.getMatchId(), request.getPoints());
            case MANUAL_CORRECT_REMAINING: return doCorrectRemaining(request.getMatchId(), request.getPoints());
            case MANUAL_CORRECT_SCORE: return doCorrectScore(request.getMatchId(), request.getPlayer(), request.getPoints());
        }
        throw new IllegalStateException("Unknown Action: " + request.getAction());

    }

    private MatchResponse doCorrectScore(Integer matchId, Integer player, Integer points) {
        MatchSummaryTO matchSummaryTO = manualCorrectionPlayerscore.forPlayer(matchId, player, points);
        return MatchResponse.from(matchSummaryTO);
    }

    private MatchResponse doCorrectRemaining(Integer matchId, Integer points) {
        MatchSummaryTO matchSummaryTO = manualCorrectionRemaining.decrease(matchId, points);
        return MatchResponse.from(matchSummaryTO);
    }


    private MatchResponse doAddFault(Integer matchId, Integer points) {
        MatchSummaryTO matchSummaryTO = addFault.madeByCurrentPlayer(matchId, points);
        return MatchResponse.from(matchSummaryTO);
    }

    private MatchResponse doChangeTurn(Integer matchId) throws Exception {
        MatchSummaryTO matchSummaryTO = changeTurn.onMatch(matchId);
        return MatchResponse.from(matchSummaryTO);
    }

    private MatchResponse doStartNewGame(Integer matchId) throws Exception {
        MatchSummaryTO matchSummaryTO = startNewGame.forMatch(matchId);
        return MatchResponse.from(matchSummaryTO);
    }

    private MatchResponse doAddPoints(Integer matchId, Integer points) throws Exception {
        //dummy implementation
        MatchSummaryTO matchSummaryTO = addPoints.toMatch(matchId, points);
        return MatchResponse.from(matchSummaryTO);
    }

}
