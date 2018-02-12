package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.CurrentFrameTO;
import be.qnh.gertronic.snooker.domain.ScoreBreakdown;

/**
 * Created by stijn on 19/01/18.
 */
public class CurrentFrameResponse {
    private int scorePlayer1;
    private int scorePlayer2;
    private BreakResponse currentBreak;
    private int currentPlayer;
    private int pointsLeft;
    private int highestBreakPlayer1;
    private int highestBreakPlayer2;
    private int latestBreakPlayer1;
    private int latestBreakPlayer2;
    private CandlePercentResponse minMax;
    private boolean currentPlayerAhead;
    private int scoreDifference;
    private ScoreBreakdown scoreBreakdown;

    public CurrentFrameResponse(){}

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public BreakResponse getCurrentBreak() {
        return currentBreak;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public int getHighestBreakPlayer1() {
        return highestBreakPlayer1;
    }

    public int getHighestBreakPlayer2() {
        return highestBreakPlayer2;
    }

    public int getLatestBreakPlayer1() {
        return latestBreakPlayer1;
    }

    public int getLatestBreakPlayer2() {
        return latestBreakPlayer2;
    }

    public int getScoreDifference() {
        return scoreDifference;
    }

    public boolean isCurrentPlayerAhead() {
        return currentPlayerAhead;
    }

    public CandlePercentResponse getMinMax() {
        return minMax;
    }

    public ScoreBreakdown getScoreBreakdown() {
        return scoreBreakdown;
    }

    private CurrentFrameResponse(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        currentBreak = builder.currentBreak;
        currentPlayer = builder.currentPlayer;
        pointsLeft = builder.pointsLeft;
        highestBreakPlayer1 = builder.highestBreakPlayer1;
        highestBreakPlayer2 = builder.highestBreakPlayer2;
        latestBreakPlayer1 = builder.latestBreakPlayer1;
        latestBreakPlayer2 = builder.latestBreakPlayer2;
        minMax = builder.minMax;
        currentPlayerAhead = builder.currentPlayerAhead;
        scoreDifference = builder.scoreDifference;
        scoreBreakdown = ScoreBreakdown.from(pointsLeft);
    }

    public static CurrentFrameResponse from(CurrentFrameTO currentFrameTO) {
        return CurrentFrameResponse.newBuilder()
                .withCurrentBreak(BreakResponse.from(currentFrameTO.currentBreak()))
                .withCurrentPlayer(currentFrameTO.currentPlayer())
                .withPointsLeft(currentFrameTO.pointsLeft())
                .withScorePlayer1(currentFrameTO.scorePlayer1())
                .withScorePlayer2(currentFrameTO.scorePlayer2())
                .withLatestBreakPlayer1(currentFrameTO.lastBreakPlayer1())
                .withLatestBreakPlayer2(currentFrameTO.lastBreakPlayer2())
                .withHighestBreakPlayer1(currentFrameTO.highestBreakPlayer1())
                .withHighestBreakPlayer2(currentFrameTO.highestBreakPlayer2())
                .withMinMax(CandlePercentResponse.from(currentFrameTO.minMax()))
                .withCurrentPlayerAhead(currentFrameTO.currentPlayerAhead())
                .withScoreDifference(currentFrameTO.scoreDifference())
                .build();
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int scorePlayer1;
        private int scorePlayer2;
        private BreakResponse currentBreak;
        private int currentPlayer;
        private int pointsLeft;
        private int highestBreakPlayer1;
        private int highestBreakPlayer2;
        private int latestBreakPlayer1;
        private int latestBreakPlayer2;
        private boolean currentPlayerAhead;
        private int scoreDifference;
        private CandlePercentResponse minMax;

        private Builder() {
        }

        public Builder withScorePlayer1(int val) {
            scorePlayer1 = val;
            return this;
        }

        public Builder withScorePlayer2(int val) {
            scorePlayer2 = val;
            return this;
        }

        public Builder withCurrentBreak(BreakResponse val) {
            currentBreak = val;
            return this;
        }

        public Builder withCurrentPlayer(int val) {
            currentPlayer = val;
            return this;
        }

        public Builder withPointsLeft(int val) {
            pointsLeft = val;
            return this;
        }

        public Builder withHighestBreakPlayer1(int val) {
            highestBreakPlayer1 = val;
            return this;
        }

        public Builder withHighestBreakPlayer2(int val) {
            highestBreakPlayer2 = val;
            return this;
        }

        public Builder withLatestBreakPlayer1(int val) {
            latestBreakPlayer1 = val;
            return this;
        }

        public Builder withLatestBreakPlayer2(int val) {
            latestBreakPlayer2 = val;
            return this;
        }

        public Builder withCurrentPlayerAhead(boolean val) {
            currentPlayerAhead = val;
            return this;
        }

        public Builder withScoreDifference(int val) {
            scoreDifference = val;
            return this;
        }

        public Builder withMinMax(CandlePercentResponse val) {
            minMax = val;
            return this;
        }

        public CurrentFrameResponse build() {
            return new CurrentFrameResponse(this);
        }
    }
}
