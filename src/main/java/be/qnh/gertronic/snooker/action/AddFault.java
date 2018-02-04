package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by stijn on 2/02/18.
 */
@Component
public class AddFault {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchSummary matchSummary;

    @Transactional
    public MatchSummaryTO madeByCurrentPlayer(int matchId, int points){
        Match match = matchRepository.findOne(matchId);
        match.addFault(points);
        return matchSummary.forMatch(matchId);
    }
}
