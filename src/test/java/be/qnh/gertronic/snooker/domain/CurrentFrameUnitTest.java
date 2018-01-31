package be.qnh.gertronic.snooker.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by stijn on 30/01/18.
 */
public class CurrentFrameUnitTest {

    @Test
    public void safePoints_1() {
        CurrentFrame frame = CurrentFrame
                .newBuilder()
                .withScorePlayer1(12)
                .withScorePlayer2(12)
                .withPointsLeft(27)
                .withCurrentPlayer(1)
                .build();

        int points = frame.safeScoreCurrentPlayer();
        Assert.assertEquals(26, points);
    }

    @Test
    public void safePoints_newFrame() {
        CurrentFrame frame = CurrentFrame
                .newBuilder()
                .withScorePlayer1(0)
                .withScorePlayer2(0)
                .withPointsLeft(147)
                .withCurrentPlayer(1)
                .build();

        int points = frame.safeScoreCurrentPlayer();
        Assert.assertEquals(80, points);
    }
}
