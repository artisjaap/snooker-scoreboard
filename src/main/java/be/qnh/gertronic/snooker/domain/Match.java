package be.qnh.gertronic.snooker.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by stijn on 17/01/2018.
 */
@Entity
@Table(name = "MATCH")
public class Match extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "PLAYER1_ID", nullable = false)
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "PLAYER2_ID", nullable = false)
    private Player player2;

    @Column(name = "PLAYED_ON")
    private LocalDate playedOn;

    @OneToMany
    @JoinColumn(name = "MATCH_ID")
    private List<Frame> framesPlayer;

    @Column(name = "NUMBER_OF_FRAMES", nullable = false)
    private int numberOfFrames;


}
