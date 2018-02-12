package be.qnh.gertronic.snooker.action.to;

import be.qnh.gertronic.snooker.domain.Frame;

import java.util.List;
import java.util.stream.Collectors;

public class FrameToAssembler {

    public static Frame assembleEntity(FrameTO frameTO){
        return Frame.newBuilder()
                .withScorePlayer1(frameTO.scorePlayer1())
                .withScorePlayer2(frameTO.scorePlayer2())
                .withFrameStart(frameTO.frameStart())
                .withFrameEnd(frameTO.frameEnd())
                .build();
    }

    public static FrameTO assembleTo(Frame frame){
        return FrameTO.newBuilder()
                .withScorePlayer1(frame.getScorePlayer1())
                .withScorePlayer2(frame.getScorePlayer2())
                .withFrameStart(frame.getFrameStart())
                .withFrameEnd(frame.getFrameEnd())
                .build();
    }

    public static List<FrameTO> assembleTo(List<Frame> frame){
        return frame.stream().map(FrameToAssembler::assembleTo).collect(Collectors.toList());
    }


}
