package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddPoints {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchSummary matchSummary;

    @Transactional
    public MatchSummaryTO toMatch(int matchId, int points){
        Match match = matchRepository.findOne(matchId);
        match.addPoints(points);
        return matchSummary.forMatch(matchId);
    }
}
