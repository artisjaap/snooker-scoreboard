package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.CurrentFrame;

public class CurrentFrameToAssembler {
    public static CurrentFrameTO assembleTo(CurrentFrame currentFrame) {
        return CurrentFrameTO.newBuilder()
                .withCurrentBreak(BreakToAssembler.assembleTo(currentFrame.getCurrentBreak()))
                .withCurrentPlayer(currentFrame.getCurrentPlayer())
                .withScorePlayer1(currentFrame.getScorePlayer1())
                .withScorePlayer2(currentFrame.getScorePlayer2())
                .withPointsLeft(currentFrame.getPointsLeft())
                .withLastBreakPlayer1(currentFrame.getLastBreakPlayer1())
                .withLastBreakPlayer2(currentFrame.getLastBreakPlayer2())
                .withHighestBreakPlayer1(currentFrame.getHighestBreakPlayer1())
                .withHighestBreakPlayer2(currentFrame.getHighestBreakPlayer2())
                .withCurrentPlayerAhead(currentFrame.currentPlayerAhead())
                .withScoreDifference(currentFrame.absoluteScoreDifference())
                .withMinMax(CandlePercentTO.newBuilder()
                                .withMinScore(currentFrame.minScoreCurrentPlayer())
                                .withMaxScore(currentFrame.maxScoreCurrentPlayer())
                                .withSafeScore(currentFrame.safeScoreCurrentPlayer())
                                .build())
                .build();
    }
}
