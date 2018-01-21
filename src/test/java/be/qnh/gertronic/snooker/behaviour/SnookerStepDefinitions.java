package be.qnh.gertronic.snooker.behaviour;

import be.qnh.gertronic.snooker.action.*;
import be.qnh.gertronic.snooker.action.to.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by stijn on 18/01/18.
 */
public class SnookerStepDefinitions extends CucumberContext {

    @Autowired
    private CreateMatch createMatch;

    @Autowired
    private SnookerWorld snookerWorld;

    @Autowired
    private AddPoints addPoints;

    @Autowired
    private MatchSummary matchSummary;

    @Autowired
    private ChangeTurn changeTurn;

    @Autowired
    private StartNewGame startNewGame;

    @Gegeven("^A new match for player ([a-zA-Z]*) ([a-zA-Z]*) Vs ([a-zA-Z]*) ([a-zA-Z]*) on the best of ([0-9]*)$")
    public void createMatch(String p1Firstname, String p1Lastname,
                            String p2Firstname, String p2Lastname,
                            Integer numberOfFrames) {
        MatchTO matchTO = MatchTO.newBuilder()
                .withDatePlayed(LocalDate.now())
                .withNumberOfFrames(numberOfFrames)
                .withPlayer1(PlayerTO.newBuilder().withFirstName(p1Firstname).withLastName(p1Lastname).build())
                .withPlayer2(PlayerTO.newBuilder().withFirstName(p2Firstname).withLastName(p2Lastname).build())
                .build();
        NewMatchTO summaryTO = createMatch.voor(matchTO);

        snookerWorld.updateMatchId(summaryTO.matchId());
        aNewFrameIsStarted();
    }

    @When("^The current player scores consecutive (.*)$")
    public void theCurrentPlayerScoresConsecutive(List<Integer> points)  {
        points.forEach(point -> addPoints.toMatch(snookerWorld.matchId(), point));
    }

    @Then("^His score will be (\\d+)$")
    public void hisScoreWillBe(int score) throws Throwable {
        MatchSummaryTO summary = matchSummary.forMatch(snookerWorld.matchId());
        CurrentFrameTO currentFrame = summary.currentFrame();
        int scoreCurrentPlayer = currentFrame.currentPlayer() == 1 ? currentFrame.scorePlayer1() : currentFrame.scorePlayer2();
        Assert.assertEquals(score, scoreCurrentPlayer);
    }

    @And("^His current break will be (\\d+)$")
    public void hisCurrentBreakWillBe(int expectedBreak) throws Throwable {
        MatchSummaryTO summary = matchSummary.forMatch(snookerWorld.matchId());
        CurrentFrameTO currentFrame = summary.currentFrame();

        Assert.assertEquals(expectedBreak, currentFrame.currentBreak());
    }

    @When("^The other player is on play$")
    public void theOtherPlayerIsOnPlay() throws Throwable {
        changeTurn.onMatch(snookerWorld.matchId());
    }



    @And("^The current score will be (\\d+) Vs (\\d+)$")
    public void theCurrentScoreWillBeVs(int p1Score, int p2Score) throws Throwable {
        MatchSummaryTO summary = matchSummary.forMatch(snookerWorld.matchId());
        CurrentFrameTO currentFrame = summary.currentFrame();

        Assert.assertEquals(p1Score, currentFrame.scorePlayer1());
        Assert.assertEquals(p2Score, currentFrame.scorePlayer2());
    }

    @And("^There are (\\d+) point left$")
    public void thereArePointLeft(int pointsLeft) throws Throwable {
        MatchSummaryTO summary = matchSummary.forMatch(snookerWorld.matchId());
        CurrentFrameTO currentFrame = summary.currentFrame();

        Assert.assertEquals(pointsLeft, currentFrame.pointsLeft());

    }

    @When("^A new frame is started$")
    public void aNewFrameIsStarted()  {
        startNewGame.forMatch(snookerWorld.matchId());
    }

    @Then("^The match will be (\\d+) Vs (\\d+) frames$")
    public void theMatchWillBeVsFrames(int p1Frames, int p2Frames) throws Throwable {
        MatchSummaryTO summary = matchSummary.forMatch(snookerWorld.matchId());
        Assert.assertEquals(p1Frames, summary.framesWonPlayer1());
        Assert.assertEquals(p2Frames, summary.framesWonPlayer2());
    }
}