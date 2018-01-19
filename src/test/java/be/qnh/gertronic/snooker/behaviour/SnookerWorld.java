package be.qnh.gertronic.snooker.behaviour;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by stijn on 18/01/18.
 */
@Component
@Scope("cucumber-glue")
public class SnookerWorld {
    private Integer matchId;

    public void updateMatchId(Integer matchId){
        this.matchId = matchId;
    }

    public int matchId() {
        return matchId;
    }
}