package be.qnh.gertronic.snooker.action.to;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class FrameTO {

    private int scorePlayer1;
    private int scorePlayer2;
    private LocalDateTime frameStart;
    private LocalDateTime frameEnd;


    public int scorePlayer1() {
        return scorePlayer1;
    }

    public int scorePlayer2() {
        return scorePlayer2;
    }

    public LocalDateTime frameStart() {
        return frameStart;
    }

    public LocalDateTime frameEnd() {
        return frameEnd;
    }

    private FrameTO(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        frameStart = builder.frameStart;
        frameEnd = builder.frameEnd;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int scorePlayer1;
        private int scorePlayer2;
        private LocalDateTime frameStart;
        private LocalDateTime frameEnd;

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

        public Builder withFrameStart(LocalDateTime val) {
            frameStart = val;
            return this;
        }

        public Builder withFrameEnd(LocalDateTime val) {
            frameEnd = val;
            return this;
        }

        public FrameTO build() {
            return new FrameTO(this);
        }
    }
}
