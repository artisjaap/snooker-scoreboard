package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.AddPoints;
import be.qnh.gertronic.snooker.action.ChangeTurn;
import be.qnh.gertronic.snooker.action.StartNewGame;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.web.request.PointsWsRequest;
import be.qnh.gertronic.snooker.web.request.MatchUpdateRequest;

import be.qnh.gertronic.snooker.web.response.MatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import sun.plugin.dom.exception.InvalidStateException;

@Controller
public class MatchWsController {

    @Autowired
    private AddPoints addPoints;

    @Autowired
    private ChangeTurn changeTurn;

    @Autowired
    private StartNewGame startNewGame;

    @MessageMapping("/match/{matchId}")
    @SendTo("/topic/currentframe/{matchId}")
    public MatchResponse processMessage(MatchUpdateRequest request) throws Exception {
        switch (request.getAction()){
            case ADD_POINTS: return doAddPoints(request.getMatchId(), request.getPoints());
            case CHANGE_TURN: return doChangeTurn(request.getMatchId());
            case START_NEW_FRAME: return doStartNewGame(request.getMatchId());
        }
        throw new InvalidStateException("Unknown Action: " + request.getAction());

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
