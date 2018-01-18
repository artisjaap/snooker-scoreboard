package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.InMemoryTest;
import be.qnh.gertronic.snooker.action.mother.MatchCreator;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.action.to.MatchTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AddPointsInMemoryTest extends InMemoryTest {

    @Autowired
    private CreateMatch createMatch;

    @Autowired
    private AddPoints addPoints;


    @Autowired
    private StartNewGame startNewGame;

    @Test
    public void addPoints() {
        MatchTO matchTO = MatchCreator.createDefault();
        MatchSummaryTO matchSummaryTO = createMatch.voor(matchTO);
        startNewGame.forMatch(matchSummaryTO.matchId());

        matchSummaryTO = addPoints.toMatch(matchSummaryTO.matchId(), 1);
        Assert.assertEquals(1, matchSummaryTO.currentFrame().scorePlayer1());
        Assert.assertEquals(0, matchSummaryTO.currentFrame().scorePlayer2());
    }
}