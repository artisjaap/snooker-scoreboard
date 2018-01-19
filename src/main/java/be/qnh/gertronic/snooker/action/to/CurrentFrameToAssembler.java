package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.CurrentFrame;

public class CurrentFrameToAssembler {
    public static CurrentFrameTO assembleTo(CurrentFrame currentFrame) {
        return CurrentFrameTO.newBuilder()
                .withCurrentBreak(currentFrame.getCurrentBreak())
                .withCurrentPlayer(currentFrame.getCurrentPlayer())
                .withScorePlayer1(currentFrame.getScorePlayer1())
                .withScorePlayer2(currentFrame.getScorePlayer2())
                .withPointsLeft(currentFrame.getPointsLeft())
                .build();
    }
}
