package be.qnh.gertronic.snooker.action.creatematch;

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

    @Transactional
    public void voor(MatchTO matchTO){
        Match match = MatchToAssembler.assembleEntity(matchTO);
        matchRepository.save(match);
    }
}
