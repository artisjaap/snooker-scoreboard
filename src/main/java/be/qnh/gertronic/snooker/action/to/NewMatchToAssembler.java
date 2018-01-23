package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.Match;

/**
 * Created by stijn on 23/01/18.
 */
public class NewMatchToAssembler {

    public static NewMatchTO assembleTO(Match match) {
        return NewMatchTO.newBuilder()
                .withMatchId(match.getId())
                .withUsername(match.getUsername())
                .withPassword(match.getPassword())
                .withPlayer1(PlayerToAssembler.assembleTo(match.getPlayer1()))
                .withPlayer2(PlayerToAssembler.assembleTo(match.getPlayer2()))
                .build();
    }
}
