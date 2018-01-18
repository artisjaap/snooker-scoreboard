package be.qnh.gertronic.snooker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "CURRENT_FRAME")
public class CurrentFrame extends AbstractEntity {

    @Column(name = "SCORE_PLAYER_1")
    private int scorePlayer1 = 0;

    @Column(name = "SCORE_PLAYER_2")
    private int scorePlayer2 = 0;

    @Column(name = "CURRENT_PLAYER")
    private int currentPlayer = 1;

    @Column(name = "CURRENT_BREAK")
    private int currentBreak = 0;

    @Column(name = "POINTS_LEFT")
    private int pointsLeft = 147;

    @Column(name = "FRAME_START", nullable = false)
    private LocalDateTime frameStart;

    @Column(name = "FRAME_END")
    private LocalDateTime frameEnd;

    protected CurrentFrame() {}

    private CurrentFrame(Builder builder) {
        scorePlayer1 = builder.scorePlayer1;
        scorePlayer2 = builder.scorePlayer2;
        currentPlayer = builder.currentPlayer;
        currentBreak = builder.currentBreak;
        pointsLeft = builder.pointsLeft;
        frameStart = builder.frameStart;
        frameEnd = builder.frameEnd;
    }

    public static CurrentFrame newFrame() {
        return newBuilder().withCurrentBreak(0)
                .withScorePlayer1(0)
                .withScorePlayer2(0)
                .withCurrentPlayer(1)
                .withPointsLeft(147)
                .withFrameStart(LocalDateTime.now())
                .build();

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

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentBreak() {
        return currentBreak;
    }

    public void setCurrentBreak(int currentBreak) {
        this.currentBreak = currentBreak;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public void setPointsLeft(int pointsLeft) {
        this.pointsLeft = pointsLeft;
    }

    public LocalDateTime getFrameStart() {
        return frameStart;
    }

    public void setFrameStart(LocalDateTime frameStart) {
        this.frameStart = frameStart;
    }

    public LocalDateTime getFrameEnd() {
        return frameEnd;
    }

    public void setFrameEnd(LocalDateTime frameEnd) {
        this.frameEnd = frameEnd;
    }

    public Frame convertToFrame() {
        return Frame.newBuilder()
                .withFrameStart(frameStart)
                .withFrameEnd(frameEnd)
                .withScorePlayer1(scorePlayer1)
                .withScorePlayer2(scorePlayer2)
                .build();
    }

    public void addPoints(int points) {
        if(currentPlayer == 1){
            scorePlayer1 += points;
        }else {
            scorePlayer2 += points;
        }

        currentBreak += points;
        updatePointsLeft(points);
    }

    private void updatePointsLeft(int points) {
        if(points == 1 && pointsLeft > 27){
            pointsLeft -= 8;
        }
        if(points > 1 && pointsLeft <= 27){
            pointsLeft -= points;
        }
    }

    public void changeTurn() {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
        currentBreak = 0;
    }


    public static final class Builder {
        private int scorePlayer1;
        private int scorePlayer2;
        private int currentPlayer;
        private int currentBreak;
        private int pointsLeft;
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

        public Builder withCurrentPlayer(int val) {
            currentPlayer = val;
            return this;
        }

        public Builder withCurrentBreak(int val) {
            currentBreak = val;
            return this;
        }

        public Builder withPointsLeft(int val) {
            pointsLeft = val;
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

        public CurrentFrame build() {
            return new CurrentFrame(this);
        }
    }
}
