package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by stijn on 6/02/18.
 */
@Component
public class ManualCorrectionPlayerscore {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchSummary matchSummary;

    @Transactional
    public MatchSummaryTO forPlayer(Integer matchId, int player, int newScore) {
        Match match = matchRepository.findOne(matchId);
        match.forcePlayerScore(player, newScore);
        return matchSummary.forMatch(matchId);
    }
}
