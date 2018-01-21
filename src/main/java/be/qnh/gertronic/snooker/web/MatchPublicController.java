package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.CreateMatch;
import be.qnh.gertronic.snooker.action.StartNewGame;
import be.qnh.gertronic.snooker.action.to.NewMatchTO;
import be.qnh.gertronic.snooker.security.JwtTokenUtil;
import be.qnh.gertronic.snooker.security.JwtUser;
import be.qnh.gertronic.snooker.web.request.NewMatchRequest;
import be.qnh.gertronic.snooker.web.response.NewMatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stijn on 20/01/18.
 */
@RestController
@RequestMapping("/public")
public class MatchPublicController {
    @Autowired
    private CreateMatch createMatch;

    @Autowired
    private StartNewGame startNewGame;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @RequestMapping(value = "/api/match/new", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<NewMatchResponse> newMatch(@RequestBody NewMatchRequest newMatchRequest){
        NewMatchTO newMatchTO = createMatch.voor(newMatchRequest.convertToTO());
        startNewGame.forMatch(newMatchTO.matchId());

        JwtUser jwtUser = JwtUser.newBuilder().withMatchId(newMatchTO.matchId())
                .withUsername(newMatchTO.username())
                .withPassword(newMatchTO.password())
                .build();

        final String token = jwtTokenUtil.generateToken(jwtUser);

        return ResponseEntity.ok(NewMatchResponse.from(newMatchTO, token));
    }

}
