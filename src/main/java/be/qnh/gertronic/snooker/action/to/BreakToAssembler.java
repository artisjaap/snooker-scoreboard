package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.Break;

/**
 * Created by stijn on 10/02/18.
 */
public class BreakToAssembler {
    public static BreakTO assembleTo(Break entity) {
        return BreakTO.newBuilder()
                .withRed(entity.getRed())
                .withYellow(entity.getYellow())
                .withGreen(entity.getGreen())
                .withBrown(entity.getBrown())
                .withBlue(entity.getBrown())
                .withPink(entity.getPink())
                .withBlack(entity.getBlack())
                .build();

    }
}
