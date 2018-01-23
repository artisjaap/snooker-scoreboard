package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.*;
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
    private StartNewGame startNewGame;

    @Autowired
    private UniqueUsernamePasswordProvider uniqueUsernamePasswordProvider;

    @Transactional
    public NewMatchTO voor(MatchTO matchTO){
        Match match = MatchToAssembler.assembleEntity(matchTO);
        UsernamePasswordTO usernamePasswordTO = uniqueUsernamePasswordProvider.generate();
        match.setUsername(usernamePasswordTO.getUsername());
        match.setPassword(usernamePasswordTO.getPassword());
        matchRepository.save(match);
        startNewGame.forMatch(match.getId());
        return NewMatchToAssembler.assembleTO(match);
    }
}
