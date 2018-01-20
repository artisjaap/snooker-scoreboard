package be.qnh.gertronic.snooker.web;

import be.qnh.gertronic.snooker.web.request.NewMatchRequest;
import be.qnh.gertronic.snooker.web.response.MatchResponse;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by stijn on 20/01/18.
 */
public class MatchControllerTest extends ControllerTest {

    @Test
    public void newMatch()throws Exception{
        NewMatchRequest request = createADefaultMatch();

        mvc.perform(
                post("/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player1.firstName", equalTo("John")))
                .andExpect(jsonPath("$.player1.lastName", equalTo("Higgins")))
                .andExpect(jsonPath("$.player2.firstName", equalTo("Mark")))
                .andExpect(jsonPath("$.player2.lastName", equalTo("Williams")))
                .andExpect(jsonPath("$.framesWonPlayer1", equalTo(0)))
                .andExpect(jsonPath("$.framesWonPlayer2", equalTo(0)))
                .andExpect(jsonPath("$.highestBreakPlayer1", equalTo(0)))
                .andExpect(jsonPath("$.highestBreakPlayer2", equalTo(0)))
                .andExpect(jsonPath("$.currentFrame.scorePlayer1", equalTo(0)))
                .andExpect(jsonPath("$.currentFrame.scorePlayer2", equalTo(0)))
                .andExpect(jsonPath("$.currentFrame.currentBreak", equalTo(0)))
                .andExpect(jsonPath("$.currentFrame.currentPlayer", equalTo(1)))
                .andExpect(jsonPath("$.currentFrame.pointsLeft", equalTo(147)))
        ;

    }


    @Test
    public void changeTurn()throws Exception{
        NewMatchRequest request = createADefaultMatch();

        MvcResult mvcResult = mvc.perform(
                post("/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentFrame.currentPlayer", equalTo(1)))
                .andReturn();
        MatchResponse matchResponse = convertResponseToObject(mvcResult, MatchResponse.class);
        int matchId = matchResponse.getMatchId();
        assertThat(matchId, greaterThan(0));

        mvc.perform(
                put("/api/match/" + matchId + "/change-turn"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPlayer", equalTo(2)));
    }

    @Test
    public void addPoints() throws Exception {
        NewMatchRequest request = createADefaultMatch();

        MvcResult mvcResult = mvc.perform(
                post("/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentFrame.currentPlayer", equalTo(1)))
                .andReturn();
        MatchResponse matchResponse = convertResponseToObject(mvcResult, MatchResponse.class);
        int matchId = matchResponse.getMatchId();
        assertThat(matchId, greaterThan(0));

        mvc.perform(
                put("/api/match/" + matchId + "/add-points/" + 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPlayer", equalTo(1)))
                .andExpect(jsonPath("$.scorePlayer1", equalTo(1)))
                .andExpect(jsonPath("$.pointsLeft", equalTo(139)))
        ;

    }

    @Test
    public void startNewFrame() throws Exception {
        NewMatchRequest request = createADefaultMatch();

        MvcResult mvcResult = mvc.perform(
                post("/api/match/new")
                        .contentType(APPLICATION_JSON_UTF8).content(
                        convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentFrame.currentPlayer", equalTo(1)))
                .andReturn();
        MatchResponse matchResponse = convertResponseToObject(mvcResult, MatchResponse.class);
        int matchId = matchResponse.getMatchId();
        assertThat(matchId, greaterThan(0));

        mvc.perform(
                put("/api/match/" + matchId + "/add-points/" + 1))
                .andExpect(status().isOk());

        mvc.perform(
                put("/api/match/" + matchId + "/new-frame/"))
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


}
