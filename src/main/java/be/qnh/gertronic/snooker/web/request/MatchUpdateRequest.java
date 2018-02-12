package be.qnh.gertronic.snooker.web.request;

/**
 * Created by stijn on 29/01/18.
 */
public class MatchUpdateRequest {
    private MatchAction action;
    private Integer matchId;

    private Integer points;
    private Integer player;
    

    public MatchAction getAction() {
        return action;
    }

    public void setAction(MatchAction action) {
        this.action = action;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPlayer() {
        return player;
    }
}
