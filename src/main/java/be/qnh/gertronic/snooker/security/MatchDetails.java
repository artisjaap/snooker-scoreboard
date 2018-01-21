package be.qnh.gertronic.snooker.security;

/**
 * Created by stijn on 20/01/18.
 */
public class MatchDetails {

    public Integer matchId;

    public Integer getMatchId() {
        return matchId;
    }

    private MatchDetails(Builder builder) {
        matchId = builder.matchId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer matchId;

        private Builder() {
        }

        public Builder withMatchId(Integer val) {
            matchId = val;
            return this;
        }

        public MatchDetails build() {
            return new MatchDetails(this);
        }
    }
}
