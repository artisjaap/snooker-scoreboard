package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.NewMatchTO;

/**
 * Created by stijn on 20/01/18.
 */
public class NewMatchResponse {
    private int matchId;
    private PlayerResponse player1;
    private PlayerResponse player2;
    private String username;
    private String password;
    private String jwtToken;

    protected NewMatchResponse(){}

    private NewMatchResponse(Builder builder) {
        setMatchId(builder.matchId);
        setPlayer1(builder.player1);
        setPlayer2(builder.player2);
        setUsername(builder.username);
        setPassword(builder.password);
        setJwtToken(builder.jwtToken);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public PlayerResponse getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerResponse player1) {
        this.player1 = player1;
    }

    public PlayerResponse getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerResponse player2) {
        this.player2 = player2;
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

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public static NewMatchResponse from(NewMatchTO newMatchTO, String token) {
        return NewMatchResponse.newBuilder()
                .withJwtToken(token)
                .withMatchId(newMatchTO.matchId())
                .withPassword(newMatchTO.password())
                .withUsername(newMatchTO.username())
                .withPlayer1(PlayerResponse.from(newMatchTO.player1()))
                .withPlayer2(PlayerResponse.from(newMatchTO.player2()))
                .build();
    }


    public static final class Builder {
        private int matchId;
        private PlayerResponse player1;
        private PlayerResponse player2;
        private String username;
        private String password;
        private String jwtToken;

        private Builder() {
        }

        public Builder withMatchId(int val) {
            matchId = val;
            return this;
        }

        public Builder withPlayer1(PlayerResponse val) {
            player1 = val;
            return this;
        }

        public Builder withPlayer2(PlayerResponse val) {
            player2 = val;
            return this;
        }

        public Builder withUsername(String val) {
            username = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Builder withJwtToken(String val) {
            jwtToken = val;
            return this;
        }

        public NewMatchResponse build() {
            return new NewMatchResponse(this);
        }
    }
}
