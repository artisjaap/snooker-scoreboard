package be.qnh.gertronic.snooker.action.to;

public class CurrentFrameTO {

    private int scorePlayer1;
    private int scorePlayer2;
    private int currentBreak;
    private int currentPlayer;
    private int pointsLeft;

    private CurrentFrameTO(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        currentBreak = builder.currentBreak;
        currentPlayer = builder.currentPlayer;
        pointsLeft = builder.pointsLeft;
    }

    public int scorePlayer1() {
        return scorePlayer1;
    }

    public int scorePlayer2() {
        return scorePlayer2;
    }

    public int currentBreak() {
        return currentBreak;
    }

    public int currentPlayer() {
        return currentPlayer;
    }

    public int pointsLeft() {
        return pointsLeft;
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

        public CurrentFrameTO build() {
            return new CurrentFrameTO(this);
        }

    }
}
