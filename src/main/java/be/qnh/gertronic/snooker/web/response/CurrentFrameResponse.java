package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.CurrentFrameTO;

/**
 * Created by stijn on 19/01/18.
 */
public class CurrentFrameResponse {
    private int scorePlayer1;
    private int scorePlayer2;
    private int currentBreak;
    private int currentPlayer;
    private int pointsLeft;

    public CurrentFrameResponse(){}

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public int getCurrentBreak() {
        return currentBreak;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    private CurrentFrameResponse(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        currentBreak = builder.currentBreak;
        currentPlayer = builder.currentPlayer;
        pointsLeft = builder.pointsLeft;
    }

    public static CurrentFrameResponse from(CurrentFrameTO currentFrameTO) {
        return CurrentFrameResponse.newBuilder()
                .withCurrentBreak(currentFrameTO.currentBreak())
                .withCurrentPlayer(currentFrameTO.currentPlayer())
                .withPointsLeft(currentFrameTO.pointsLeft())
                .withScorePlayer1(currentFrameTO.scorePlayer1())
                .withScorePlayer2(currentFrameTO.scorePlayer2())
                .build();
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int scorePlayer1;
        private int scorePlayer2;
        private int currentBreak;
        private int currentPlayer;
        private int pointsLeft;

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

        public Builder withCurrentBreak(int val) {
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

        public CurrentFrameResponse build() {
            return new CurrentFrameResponse(this);
        }
    }
}
