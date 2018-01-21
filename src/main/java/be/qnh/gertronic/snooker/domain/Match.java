package be.qnh.gertronic.snooker.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by stijn on 17/01/2018.
 */
@Entity
@Table(name = "MATCH")
public class Match extends AbstractEntity{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER1_ID", nullable = false)
    private Player player1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER2_ID", nullable = false)
    private Player player2;

    @Column(name = "PLAYED_ON")
    private LocalDate playedOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MATCH_ID")
    private List<Frame> framesPlayed;

    @Column(name = "NUMBER_OF_FRAMES", nullable = false)
    private int numberOfFrames;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENT_FRAME_ID")
    private CurrentFrame currentFrame;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public LocalDate getPlayedOn() {
        return playedOn;
    }

    public List<Frame> getFramesPlayed() {
        return framesPlayed;
    }

    public int getNumberOfFrames() {
        return numberOfFrames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //default coonstructor required for JPA
    protected Match() {

    }

    private Match(Builder builder) {
        player1 = builder.player1;
        player2 = builder.player2;
        playedOn = builder.playedOn;
        framesPlayed = builder.framesPlayed;
        numberOfFrames = builder.numberOfFrames;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void addFrame(Frame frame) {
        framesPlayed.add(frame);
    }

    public int wonByPlayer1() {
        return new Long(framesPlayed.stream().filter(frame -> frame.getScorePlayer1() > frame.getScorePlayer2()).count()).intValue();
    }

    public int wonByPlayer2() {
        return new Long(framesPlayed.stream().filter(frame -> frame.getScorePlayer2() > frame.getScorePlayer1()).count()).intValue();
    }


    public Optional<CurrentFrame> gameInProgrogress() {
        return Optional.ofNullable(currentFrame);
    }

    public void startNewGame() {
        gameInProgrogress().ifPresent(currentFrame -> {
            currentFrame.setFrameEnd(LocalDateTime.now());
            framesPlayed.add(currentFrame.convertToFrame());
        });
        currentFrame = CurrentFrame.newFrame();
    }

    public void addPoints(int points) {
        gameInProgrogress().ifPresent(currentFrame1 -> {
            currentFrame.addPoints(points);
        });
    }

    public void changeTurn() {
        gameInProgrogress().ifPresent(CurrentFrame::changeTurn);
    }

    public static final class Builder {
        private Player player1;
        private Player player2;
        private LocalDate playedOn;
        private List<Frame> framesPlayed = new ArrayList<>();
        private int numberOfFrames;

        private Builder() {
        }

        public Builder withPlayer1(Player val) {
            player1 = val;
            return this;
        }

        public Builder withPlayer2(Player val) {
            player2 = val;
            return this;
        }

        public Builder withPlayedOn(LocalDate val) {
            playedOn = val;
            return this;
        }

        public Builder withFramesPlayed(List<Frame> val) {
            framesPlayed = val;
            return this;
        }

        public Builder withNumberOfFrames(int val) {
            numberOfFrames = val;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
