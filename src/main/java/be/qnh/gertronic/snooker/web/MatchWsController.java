package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.to.CurrentFrameTO;
import be.qnh.gertronic.snooker.action.to.PointsWsRequest;
import be.qnh.gertronic.snooker.web.response.CurrentFrameResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MatchWsController {

    @MessageMapping("/match/{matchId}")
    @SendTo("/topic/currentframe/{matchId}")
    public CurrentFrameResponse addPoints(PointsWsRequest points) throws Exception {
        //dummy implementation
        return CurrentFrameResponse.newBuilder().withCurrentBreak(points.getPoints()).build();
    }


}
