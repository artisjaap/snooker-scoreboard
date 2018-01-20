package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.action.to.MatchTO;
import be.qnh.gertronic.snooker.action.to.MatchToAssembler;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreateMatch {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchSummary matchSummary;

    @Autowired
    private StartNewGame startNewGame;

    @Transactional
    public MatchSummaryTO voor(MatchTO matchTO){
        Match match = MatchToAssembler.assembleEntity(matchTO);
        matchRepository.save(match);
        startNewGame.forMatch(match.getId());
        return matchSummary.forMatch(match.getId());
    }
}
