package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.Match;

public class MatchToAssembler {

    public static Match assembleEntity(MatchTO matchTO){
        return Match.newBuilder()
                .withNumberOfFrames(matchTO.numberOfFrames())
                .withPlayedOn(matchTO.datePlayed())
                .withPlayer1(PlayerToAssembler.assembleTo(matchTO.player1()))
                .withPlayer2(PlayerToAssembler.assembleTo(matchTO.player2()))
                .build();
    }
}
