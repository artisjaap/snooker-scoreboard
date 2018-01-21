package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.security.MatchDetails;
import be.qnh.gertronic.snooker.web.request.NewMatchRequest;
import be.qnh.gertronic.snooker.web.response.NewMatchResponse;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by stijn on 20/01/18.
 */
public class MatchControllerTest extends ControllerTest {

    @Test
    public void newMatch()throws Exception{
        NewMatchRequest request = createADefaultMatch();

        mvc.perform(
                post("/public/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player1.firstName", equalTo("John")))
                .andExpect(jsonPath("$.player1.lastName", equalTo("Higgins")))
                .andExpect(jsonPath("$.player2.firstName", equalTo("Mark")))
                .andExpect(jsonPath("$.player2.lastName", equalTo("Williams")))

        ;

    }

    @Test
    public void changeTurnRequiresAuthentication()throws Exception{
         mvc.perform(
                put("/secure/api/match/" + 1 + "/change-turn")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(createADefaultMatch())))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    public void changeTurn()throws Exception{
        NewMatchRequest request = createADefaultMatch();

        MvcResult mvcResult = mvc.perform(
                post("/public/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andReturn();
        NewMatchResponse matchResponse = convertResponseToObject(mvcResult, NewMatchResponse.class);
        int matchId = matchResponse.getMatchId();
        assertThat(matchId, greaterThan(0));

        UsernamePasswordAuthenticationToken authentication = createBasicAuthentication(matchId);
        mvc.perform(
                put("/secure/api/match/" + matchId + "/change-turn").with(authentication(authentication)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPlayer", equalTo(2)));
    }



    @Test
    public void addPointsRequiresAuthentication() throws Exception{
        mvc.perform(
                put("/secure/api/match/" + 1 + "/add-points/10")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(createADefaultMatch())))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    public void addPoints() throws Exception {
        NewMatchRequest request = createADefaultMatch();

        MvcResult mvcResult = mvc.perform(
                post("/public/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andReturn();
        NewMatchResponse matchResponse = convertResponseToObject(mvcResult, NewMatchResponse.class);
        int matchId = matchResponse.getMatchId();
        assertThat(matchId, greaterThan(0));

        UsernamePasswordAuthenticationToken authentication = createBasicAuthentication(matchId);
        mvc.perform(
                put("/secure/api/match/" + matchId + "/add-points/" + 1).with(authentication(authentication)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPlayer", equalTo(1)))
                .andExpect(jsonPath("$.scorePlayer1", equalTo(1)))
                .andExpect(jsonPath("$.pointsLeft", equalTo(139)))
        ;

    }

    @Test
    public void startNewFrameRequiresAuthentication() throws Exception{
        mvc.perform(
                put("/secure/api/match/" + 1 + "/new-frame")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(createADefaultMatch())))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    public void startNewFrame() throws Exception {
        NewMatchRequest request = createADefaultMatch();

        MvcResult mvcResult = mvc.perform(
                post("/public/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andReturn();
        NewMatchResponse matchResponse = convertResponseToObject(mvcResult, NewMatchResponse.class);
        int matchId = matchResponse.getMatchId();
        assertThat(matchId, greaterThan(0));

        UsernamePasswordAuthenticationToken authentication = createBasicAuthentication(matchId);
        mvc.perform(
                put("/secure/api/match/" + matchId + "/add-points/" + 1).with(authentication(authentication)))
                .andExpect(status().isOk());

        mvc.perform(
                put("/secure/api/match/" + matchId + "/new-frame/").with(authentication(authentication)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPlayer", equalTo(1)))
                .andExpect(jsonPath("$.scorePlayer1", equalTo(0)))
                .andExpect(jsonPath("$.scorePlayer2", equalTo(0)))
                .andExpect(jsonPath("$.pointsLeft", equalTo(147)))
        ;

    }

    private NewMatchRequest createADefaultMatch() {
        NewMatchRequest request = new NewMatchRequest();
        request.setFirstNamePlayer1("John");
        request.setLastNamePlayer1("Higgins");
        request.setFirstNamePlayer2("Mark");
        request.setLastNamePlayer2("Williams");
        request.setNumberOfFrames(5);
        return request;
    }

    private UsernamePasswordAuthenticationToken createBasicAuthentication(int matchId) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("user", null, null);
        MatchDetails details = MatchDetails.newBuilder().withMatchId(matchId).build();
        authentication.setDetails(details);
        return authentication;
    }


}
