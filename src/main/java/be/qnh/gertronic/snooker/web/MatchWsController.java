package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.AddPoints;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.action.to.PointsWsRequest;
import be.qnh.gertronic.snooker.web.response.CurrentFrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MatchWsController {

    @Autowired
    private AddPoints addPoints;

    @MessageMapping("/match/{matchId}")
    @SendTo("/topic/currentframe/{matchId}")
    public CurrentFrameResponse addPoints(PointsWsRequest points) throws Exception {
        //dummy implementation
        MatchSummaryTO matchSummaryTO = addPoints.toMatch(points.getMatchId(), points.getPoints());
        return CurrentFrameResponse.from(matchSummaryTO.currentFrame());
    }


}