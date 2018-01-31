package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.CandlePercentTO;

/**
 * Created by stijn on 30/01/18.
 */
public class CandlePercentResponse {
    private Integer minScore;
    private Integer maxScore;
    private Integer saveScore;

    private CandlePercentResponse(Builder builder) {
        minScore = builder.minScore;
        maxScore = builder.maxScore;
        saveScore = builder.saveScore;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getMinScore() {
        return minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public Integer getSaveScore() {
        return saveScore;
    }

    public static CandlePercentResponse from(CandlePercentTO to) {
        return CandlePercentResponse.newBuilder()
                .withMaxScore(to.maxScore())
                .withMinScore(to.minScore())
                .withSaveScore(to.saveScore())
                .build();
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

        public Builder withSaveScore(Integer val) {
            saveScore = val;
            return this;
        }

        public CandlePercentResponse build() {
            return new CandlePercentResponse(this);
        }
    }
}
