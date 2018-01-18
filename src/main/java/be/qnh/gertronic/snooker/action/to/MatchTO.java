package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.action.PlayerTO;

import java.time.LocalDate;

public class MatchTO {
    private PlayerTO player1;
    private PlayerTO player2;
    private int numberOfFrames;
    private LocalDate datePlayed;

    public PlayerTO player1() {
        return player1;
    }

    public PlayerTO player2() {
        return player2;
    }

    public int numberOfFrames() {
        return numberOfFrames;
    }

    public LocalDate datePlayed() {
        return datePlayed;
    }

    private MatchTO(Builder builder) {
        player1 = builder.player1;
        player2 = builder.player2;
        numberOfFrames = builder.numberOfFrames;
        datePlayed = builder.datePlayed;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private PlayerTO player1;
        private PlayerTO player2;
        private int numberOfFrames = 1;
        private LocalDate datePlayed = LocalDate.now();

        private Builder() {
        }

        public Builder withPlayer1(PlayerTO val) {
            player1 = val;
            return this;
        }

        public Builder withPlayer2(PlayerTO val) {
            player2 = val;
            return this;
        }

        public Builder withNumberOfFrames(int val) {
            numberOfFrames = val;
            return this;
        }

        public Builder withDatePlayed(LocalDate val) {
            datePlayed = val;
            return this;
        }

        public MatchTO build() {
            return new MatchTO(this);
        }
    }
}
