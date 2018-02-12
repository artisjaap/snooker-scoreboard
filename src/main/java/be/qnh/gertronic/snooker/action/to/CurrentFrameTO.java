package be.qnh.gertronic.snooker.action.to;

public class CurrentFrameTO {

    private int scorePlayer1;
    private int scorePlayer2;
    private BreakTO currentBreak;
    private int currentPlayer;
    private int pointsLeft;
    private int lastBreakPlayer1;
    private int lastBreakPlayer2;
    private int highestBreakPlayer1;
    private int highestBreakPlayer2;
    private CandlePercentTO minMax;
    private int scoreDifference;
    private boolean currentPlayerAhead;

    private CurrentFrameTO(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        currentBreak = builder.currentBreak;
        currentPlayer = builder.currentPlayer;
        pointsLeft = builder.pointsLeft;
        lastBreakPlayer1 = builder.lastBreakPlayer1;
        lastBreakPlayer2 = builder.lastBreakPlayer2;
        highestBreakPlayer1 = builder.highestBreakPlayer1;
        highestBreakPlayer2 = builder.highestBreakPlayer2;
        minMax = builder.minMax;
        scoreDifference = builder.scoreDifference;
        currentPlayerAhead = builder.currentPlayerAhead;

    }

    public int scorePlayer1() {
        return scorePlayer1;
    }

    public int scorePlayer2() {
        return scorePlayer2;
    }

    public BreakTO currentBreak() {
        return currentBreak;
    }

    public int currentPlayer() {
        return currentPlayer;
    }

    public int pointsLeft() {
        return pointsLeft;
    }

    public int highestBreakPlayer1() {
        return highestBreakPlayer1;
    }

    public int highestBreakPlayer2() {
        return highestBreakPlayer2;
    }

    public int lastBreakPlayer1() {
        return lastBreakPlayer1;
    }

    public int lastBreakPlayer2() {
        return lastBreakPlayer2;
    }

    public CandlePercentTO minMax() {
        return minMax;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean currentPlayerAhead() {
        return currentPlayerAhead;
    }

    public int scoreDifference() {
        return scoreDifference;
    }


    public static final class Builder {
        private int scorePlayer1;
        private int scorePlayer2;
        private BreakTO currentBreak;
        private int currentPlayer;
        private int pointsLeft;
        private int lastBreakPlayer1;
        private int lastBreakPlayer2;
        private int highestBreakPlayer1;
        private int highestBreakPlayer2;
        private CandlePercentTO minMax;
        public int scoreDifference;
        public boolean currentPlayerAhead;

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

        public Builder withCurrentBreak(BreakTO val) {
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

        public Builder withLastBreakPlayer1(int val) {
            lastBreakPlayer1 = val;
            return this;
        }

        public Builder withLastBreakPlayer2(int val) {
            lastBreakPlayer2 = val;
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

        public Builder withScoreDifference(int val) {
            scoreDifference = val;
            return this;
        }

        public Builder withCurrentPlayerAhead(boolean val) {
            currentPlayerAhead = val;
            return this;
        }



        public Builder withMinMax(CandlePercentTO val) {
            minMax = val;
            return this;
        }

        public CurrentFrameTO build() {
            return new CurrentFrameTO(this);
        }

    }
}
