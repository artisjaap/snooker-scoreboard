package be.qnh.gertronic.snooker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by stijn on 17/01/2018.
 */
@Entity
@Table(name = "FRAME")
public class Frame extends AbstractEntity{
    @Column(name = "SCORE_PLAYER_1", nullable = false)
    private int scorePlayer1 = 0;

    @Column(name = "SCORE_PLAYER_2", nullable = false)
    private int scorePlayer2 = 0;

    @Column(name = "FRAME_START", nullable = false)
    private LocalDateTime frameStart;

    @Column(name = "FRAME_END")
    private LocalDateTime frameEnd;

    protected Frame(){}
    
    private Frame(Builder builder) {
        setScorePlayer1(builder.scorePlayer1);
        setScorePlayer2(builder.scorePlayer2);
        frameStart = builder.frameStart;
        frameEnd = builder.frameEnd;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public LocalDateTime getFrameEnd() {
        return frameEnd;
    }

    public LocalDateTime getFrameStart() {
        return frameStart;
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

        public Frame build() {
            return new Frame(this);
        }
    }
}
