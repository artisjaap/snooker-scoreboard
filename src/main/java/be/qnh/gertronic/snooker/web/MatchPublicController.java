package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.action.AuthenticateForMatch;
import be.qnh.gertronic.snooker.action.CreateMatch;
import be.qnh.gertronic.snooker.action.MatchSummary;
import be.qnh.gertronic.snooker.action.StartNewGame;
import be.qnh.gertronic.snooker.action.to.MatchFullSummaryTO;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.action.to.NewMatchTO;
import be.qnh.gertronic.snooker.security.JwtTokenUtil;
import be.qnh.gertronic.snooker.security.JwtUser;
import be.qnh.gertronic.snooker.web.request.NewMatchRequest;
import be.qnh.gertronic.snooker.web.response.MatchFullSummaryResponse;
import be.qnh.gertronic.snooker.web.response.MatchResponse;
import be.qnh.gertronic.snooker.web.response.NewMatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
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

    @Autowired
    private MatchSummary matchSummary;

    @Autowired
    private AuthenticateForMatch authenticateForMatch;

    @RequestMapping(value = "/api/match/{matchId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<MatchResponse> newMatch(@PathVariable Integer matchId){
        MatchSummaryTO matchSummaryTO = matchSummary.forMatch(matchId);
        return ResponseEntity.ok(MatchResponse.from(matchSummaryTO));
    }

    @RequestMapping(value = "/api/match/summary/{matchId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<MatchFullSummaryResponse> matchSummary(@PathVariable Integer matchId){
        MatchFullSummaryTO matchSummaryTO = matchSummary.forMatchFullSummary(matchId);
        return ResponseEntity.ok(MatchFullSummaryResponse.from(matchSummaryTO));
    }


    @RequestMapping(value = "/api/match/new", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<NewMatchResponse> newMatch(@RequestBody NewMatchRequest newMatchRequest){
        NewMatchTO newMatchTO = createMatch.voor(newMatchRequest.convertToTO());
        startNewGame.forMatch(newMatchTO.matchId());

        JwtUser jwtUser = createJwtUser(newMatchTO);

        final String token = jwtTokenUtil.generateToken(jwtUser);

        return ResponseEntity.ok(NewMatchResponse.from(newMatchTO, token));
    }

    private JwtUser createJwtUser(NewMatchTO newMatchTO) {
        return JwtUser.newBuilder().withMatchId(newMatchTO.matchId())
                .withUsername(newMatchTO.username())
                .withPassword(newMatchTO.password())
                .build();
    }

    @RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<NewMatchResponse> login(@PathVariable String username, @PathVariable String password){
        NewMatchTO newMatchTO = authenticateForMatch.byUsernameAndPassword(username, password)
                .orElseThrow(() -> new InsufficientAuthenticationException("invalid username password"));
        JwtUser jwtUser = createJwtUser(newMatchTO);
        final String token = jwtTokenUtil.generateToken(jwtUser);

        return ResponseEntity.ok(NewMatchResponse.from(newMatchTO, token));

    }

}
