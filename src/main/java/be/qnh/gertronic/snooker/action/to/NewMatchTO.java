package be.qnh.gertronic.snooker.action.to;

/**
 * Created by stijn on 20/01/18.
 */
public class NewMatchTO {

    private int matchId;
    private PlayerTO player1;
    private PlayerTO player2;
    private String username;
    private String password;

    public int matchId() {
        return matchId;
    }

    public PlayerTO player1() {
        return player1;
    }

    public PlayerTO player2() {
        return player2;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    private NewMatchTO(Builder builder) {
        matchId = builder.matchId;
        player1 = builder.player1;
        player2 = builder.player2;
        username = builder.username;
        password = builder.password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int matchId;
        private PlayerTO player1;
        private PlayerTO player2;
        private String username;
        private String password;

        private Builder() {
        }

        public Builder withMatchId(int val) {
            matchId = val;
            return this;
        }

        public Builder withPlayer1(PlayerTO val) {
            player1 = val;
            return this;
        }

        public Builder withPlayer2(PlayerTO val) {
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

        public NewMatchTO build() {
            return new NewMatchTO(this);
        }
    }
}
