package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.Frame;

public class FrameToAssembler {

    public static Frame assembleEntity(FrameTO frameTO){
        return Frame.newBuilder()
                .withScorePlayer1(frameTO.scorePlayer1())
                .withScorePlayer2(frameTO.scorePlayer2())
                .withFrameStart(frameTO.frameStart())
                .withFrameEnd(frameTO.frameEnd())
                .build();
    }
}
