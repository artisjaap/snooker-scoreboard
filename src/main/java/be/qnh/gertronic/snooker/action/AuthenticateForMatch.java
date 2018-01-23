package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.NewMatchTO;
import be.qnh.gertronic.snooker.action.to.NewMatchToAssembler;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by stijn on 20/01/18.
 */
@Component
public class AuthenticateForMatch {
    @Autowired
    private MatchRepository matchRepository;

    public Optional<NewMatchTO> byUsernameAndPassword(String username, String password){
        return matchRepository.findByUsernameAndPassword(username, password)
                .map(NewMatchToAssembler::assembleTO);
    }
}
