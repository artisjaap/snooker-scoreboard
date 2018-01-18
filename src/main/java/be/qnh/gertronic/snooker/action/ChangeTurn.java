package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ChangeTurn {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchSummary matchSummary;

    @Transactional
    public MatchSummaryTO onMatch(int matchId){
        Match match = matchRepository.findOne(matchId);
        match.changeTurn();
        return matchSummary.forMatch(matchId);
    }
}
