package be.qnh.gertronic.snooker.action.to;

public class MatchSummaryTO {

    private int matchId;
    private PlayerTO player1;
    private PlayerTO player2;
    private int framesWonPlayer1;
    private int framesWonPlayer2;
    private int highestBreakPlayer1;
    private int highestBreakPlayer2;
    private CurrentFrameTO currentFrame;

    public int matchId() {
        return matchId;
    }

    public PlayerTO player1() {
        return player1;
    }

    public PlayerTO player2() {
        return player2;
    }

    public int framesWonPlayer1() {
        return framesWonPlayer1;
    }

    public int framesWonPlayer2() {
        return framesWonPlayer2;
    }

    public int highestBreakPlayer1() {
        return highestBreakPlayer1;
    }

    public int highestBreakPlayer2() {
        return highestBreakPlayer2;
    }

    public CurrentFrameTO currentFrame() {
        return currentFrame;
    }

    private MatchSummaryTO(Builder builder) {
        matchId = builder.matchId;
        player1 = builder.player1;
        player2 = builder.player2;
        framesWonPlayer1 = builder.framesWonPlayer1;
        framesWonPlayer2 = builder.framesWonPlayer2;
        highestBreakPlayer1 = builder.highestBreakPlayer1;
        highestBreakPlayer2 = builder.highestBreakPlayer2;
        currentFrame = builder.currentFrame;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int matchId;
        private PlayerTO player1;
        private PlayerTO player2;
        private int framesWonPlayer1;
        private int framesWonPlayer2;
        private int highestBreakPlayer1;
        private int highestBreakPlayer2;
        private CurrentFrameTO currentFrame;

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

        public Builder withFramesWonPlayer1(int val) {
            framesWonPlayer1 = val;
            return this;
        }

        public Builder withFramesWonPlayer2(int val) {
            framesWonPlayer2 = val;
            return this;
        }

        public Builder withHighestBreakPlayer1(int val) {
            highestBreakPlayer1 = val;
            return this;
        }

        public Builder withHighestBreakPlayer2(int val) {
            highestBreakPlayer2 = val;
            return this;
        }

        public Builder withCurrentFrame(CurrentFrameTO val) {
            currentFrame = val;
            return this;
        }

        public MatchSummaryTO build() {
            return new MatchSummaryTO(this);
        }
    }
}
