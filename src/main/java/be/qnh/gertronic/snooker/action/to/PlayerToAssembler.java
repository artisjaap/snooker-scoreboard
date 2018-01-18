package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.Player;

public class PlayerToAssembler {

    public static Player assembleTo(PlayerTO playerTO){
        return Player.newBuilder()
                .withFirstname(playerTO.firstName())
                .withLastname(playerTO.lastName())
                .build();
    }

    public static PlayerTO assembleTo(Player player){
        return PlayerTO.newBuilder()
                .withFirstName(player.getFirstname())
                .withLastName(player.getLastname())
                .build();
    }

}
