package be.qnh.gertronic.snooker.web.request;

public class PointsWsRequest {

    private Integer points;
    private Integer matchId;

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
}
