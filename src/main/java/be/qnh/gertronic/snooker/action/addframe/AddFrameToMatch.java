package be.qnh.gertronic.snooker.action.addframe;

import be.qnh.gertronic.snooker.action.to.FrameTO;
import be.qnh.gertronic.snooker.action.to.FrameToAssembler;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddFrameToMatch {

    @Autowired
    private MatchRepository matchRepository;

    @Transactional
    public void addFrame(Integer matchId, FrameTO frameTo){
        Match match = matchRepository.findOne(matchId);
        match.addFrame(FrameToAssembler.assembleEntity(frameTo));
    }
}
