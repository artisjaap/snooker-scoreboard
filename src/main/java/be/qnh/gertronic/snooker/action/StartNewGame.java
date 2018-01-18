package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StartNewGame {

    @Autowired
    private MatchRepository matchRepository;

    @Transactional
    public void forMatch(int matchId){
        Match match = matchRepository.findOne(matchId);
        match.startNewGame();
    }
}
