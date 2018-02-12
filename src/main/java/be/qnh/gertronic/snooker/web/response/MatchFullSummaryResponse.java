package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.MatchFullSummaryTO;

import java.util.List;

/**
 * Created by stijn on 10/02/18.
 */
public class MatchFullSummaryResponse {
    private int matchId;
    private PlayerResponse player1;
    private PlayerResponse player2;
    private int framesWonPlayer1;
    private int framesWonPlayer2;
    private int highestBreakPlayer1;
    private int highestBreakPlayer2;
    private int numberOfFrames;
    private List<FrameResponse> frames;

    public int getMatchId() {
        return matchId;
    }

    public PlayerResponse getPlayer1() {
        return player1;
    }

    public PlayerResponse getPlayer2() {
        return player2;
    }

    public int getFramesWonPlayer1() {
        return framesWonPlayer1;
    }

    public int getFramesWonPlayer2() {
        return framesWonPlayer2;
    }

    public int getHighestBreakPlayer1() {
        return highestBreakPlayer1;
    }

    public int getHighestBreakPlayer2() {
        return highestBreakPlayer2;
    }

    public int getNumberOfFrames() {
        return numberOfFrames;
    }

    public List<FrameResponse> getFrames() {
        return frames;
    }

    private MatchFullSummaryResponse(Builder builder) {
        matchId = builder.matchId;
        player1 = builder.player1;
        player2 = builder.player2;
        framesWonPlayer1 = builder.framesWonPlayer1;
        framesWonPlayer2 = builder.framesWonPlayer2;
        highestBreakPlayer1 = builder.highestBreakPlayer1;
        highestBreakPlayer2 = builder.highestBreakPlayer2;
        numberOfFrames = builder.numberOfFrames;
        frames = builder.frames;
    }

    public static MatchFullSummaryResponse from(MatchFullSummaryTO summaryTO) {
        return MatchFullSummaryResponse.newBuilder()
                .withFramesWonPlayer1(summaryTO.framesWonPlayer1())
                .withFramesWonPlayer2(summaryTO.framesWonPlayer2())
                .withHighestBreakPlayer1(summaryTO.highestBreakPlayer1())
                .withHighestBreakPlayer2(summaryTO.highestBreakPlayer2())
                .withMatchId(summaryTO.matchId())
                .withPlayer1(PlayerResponse.from(summaryTO.player1()))
                .withPlayer2(PlayerResponse.from(summaryTO.player2()))
                .withNumberOfFrames(summaryTO.numberOfFrames())
                .withFrames(FrameResponse.from(summaryTO.framesPlayed()))
                .build();


    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int matchId;
        private PlayerResponse player1;
        private PlayerResponse player2;
        private int framesWonPlayer1;
        private int framesWonPlayer2;
        private int highestBreakPlayer1;
        private int highestBreakPlayer2;
        private int numberOfFrames;
        private List<FrameResponse> frames;

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

        public Builder withNumberOfFrames(int val) {
            numberOfFrames = val;
            return this;
        }

        public Builder withFrames(List<FrameResponse> val) {
            frames = val;
            return this;
        }

        public MatchFullSummaryResponse build() {
            return new MatchFullSummaryResponse(this);
        }
    }
}
