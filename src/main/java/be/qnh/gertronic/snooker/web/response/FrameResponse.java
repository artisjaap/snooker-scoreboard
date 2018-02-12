package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.FrameTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by stijn on 10/02/18.
 */
public class FrameResponse {
    private Integer scorePlayer1;
    private Integer scorePlayer2;
    private LocalDateTime frameStart;
    private LocalDateTime frameStop;

    private FrameResponse(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        frameStart = builder.frameStart;
        frameStop = builder.frameStop;
    }

    public Integer getScorePlayer1() {
        return scorePlayer1;
    }

    public Integer getScorePlayer2() {
        return scorePlayer2;
    }

    public LocalDateTime getFrameStart() {
        return frameStart;
    }

    public LocalDateTime getFrameStop() {
        return frameStop;
    }

    public static FrameResponse from(FrameTO frame){
        return FrameResponse.newBuilder()
                .withScorePlayer1(frame.scorePlayer1())
                .withScorePlayer2(frame.scorePlayer2())
                .withFrameStart(frame.frameStart())
                .withFrameEnd(frame.frameEnd())
                .build();
    }

    public static List<FrameResponse> from(List<FrameTO> frames){
        return frames.stream().map(FrameResponse::from).collect(Collectors.toList());

    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer scorePlayer1;
        private Integer scorePlayer2;
        private LocalDateTime frameStart;
        private LocalDateTime frameStop;

        private Builder() {
        }

        public Builder withScorePlayer1(Integer val) {
            scorePlayer1 = val;
            return this;
        }

        public Builder withScorePlayer2(Integer val) {
            scorePlayer2 = val;
            return this;
        }

        public Builder withFrameStart(LocalDateTime val) {
            frameStart = val;
            return this;
        }

        public Builder withFrameEnd(LocalDateTime val) {
            frameStop = val;
            return this;
        }

        public FrameResponse build() {
            return new FrameResponse(this);
        }
    }
}
