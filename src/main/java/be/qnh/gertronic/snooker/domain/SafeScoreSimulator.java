package be.qnh.gertronic.snooker.domain;

/**
 * Created by stijn on 30/01/18.
 */
public class SafeScoreSimulator {
    private final int score1;
    private final int score2;
    private final int scoreLeft;

    public int calculate() {
        boolean virtualyWon = score1 > score2 + scoreLeft;
        if(virtualyWon){
            return score1;
        }

        boolean snookersRequiredStage = score1 + scoreLeft < score2;
        if(snookersRequiredStage){
            return score1 + scoreLeft;
        }

        int localScoreLeft = scoreLeft;
        int localScore1 = score1;
        while(localScoreLeft > 0 && localScore1 < score2 + localScoreLeft) {
            int pointsToAdd = decreaseStep();
            localScore1 += pointsToAdd;
            localScoreLeft -= pointsToAdd;

        }
        return localScore1;
    }

    private int decreaseStep() {
        switch (scoreLeft){
            case 7:
                return 7;
            case 13:
                return 6;
            case 18:
                return 5;
            case 22:
                return 4;
            case 25:
                return 3;
            case 27:
                return 2;
            default:
                return 8;

        }

    }

    private SafeScoreSimulator(Builder builder) {
        score1 = builder.score1;
        score2 = builder.score2;
        scoreLeft = builder.scoreLeft;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int score1;
        private int score2;
        private int scoreLeft;

        private Builder() {
        }

        public Builder withScore1(int val) {
            score1 = val;
            return this;
        }

        public Builder withScore2(int val) {
            score2 = val;
            return this;
        }

        public Builder withScoreLeft(int val) {
            scoreLeft = val;
            return this;
        }

        private SafeScoreSimulator build() {
            return new SafeScoreSimulator(this);
        }

        public int calculate() {
            return build().calculate();
        }
    }
}
