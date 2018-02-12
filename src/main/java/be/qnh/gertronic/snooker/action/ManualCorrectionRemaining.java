package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by stijn on 5/02/18.
 */
@Component
public class ManualCorrectionRemaining {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchSummary matchSummary;

    @Transactional
    public MatchSummaryTO decrease(Integer matchId, Integer value) {
        Match match = matchRepository.findOne(matchId);
        match.decreaseRemaining(value);
        return matchSummary.forMatch(matchId);
    }
}
