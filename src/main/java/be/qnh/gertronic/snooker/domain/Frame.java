package be.qnh.gertronic.snooker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
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
}
