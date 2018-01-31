package be.qnh.gertronic.snooker.action.to;

/**
 * Created by stijn on 30/01/18.
 */
public class CandlePercentTO {

    private Integer minScore;
    private Integer maxScore;
    private Integer saveScore;

    public Integer minScore() {
        return minScore;
    }

    public Integer maxScore() {
        return maxScore;
    }

    public Integer saveScore() {
        return saveScore;
    }

    private CandlePercentTO(Builder builder) {
        minScore = builder.minScore;
        maxScore = builder.maxScore;
        saveScore = builder.saveScore;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer minScore;
        private Integer maxScore;
        private Integer saveScore;

        private Builder() {
        }

        public Builder withMinScore(Integer val) {
            minScore = val;
            return this;
        }

        public Builder withMaxScore(Integer val) {
            maxScore = val;
            return this;
        }

        public Builder withSafeScore(Integer val) {
            saveScore = val;
            return this;
        }

        public CandlePercentTO build() {
            return new CandlePercentTO(this);
        }
    }
}
