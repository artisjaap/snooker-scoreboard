package be.qnh.gertronic.snooker.action;


import be.qnh.gertronic.snooker.action.to.CurrentFrameToAssembler;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.action.to.PlayerToAssembler;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MatchSummary {

    @Autowired
    private MatchRepository matchRepository;

    @Transactional
    public MatchSummaryTO forMatch(Integer matchId){
        Match match = matchRepository.findOne(matchId);

        return MatchSummaryTO.newBuilder()
                .withFramesWonPlayer1(match.wonByPlayer1())
                .withFramesWonPlayer2(match.wonByPlayer2())
                .withPlayer1(PlayerToAssembler.assembleTo(match.getPlayer1()))
                .withPlayer2(PlayerToAssembler.assembleTo(match.getPlayer2()))
                .withMatchId(match.getId())
                .withNumberOfFrames(match.getNumberOfFrames())
                .withCurrentFrame(match.gameInProgrogress().map(CurrentFrameToAssembler::assembleTo).orElse(null))
                .build();

    }
}
