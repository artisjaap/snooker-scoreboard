package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.UsernamePasswordTO;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by stijn on 20/01/18.
 */
@Component
public class UniqueUsernamePasswordProvider {

    @Autowired
    private MatchRepository matchRepository;

    public UsernamePasswordTO generate(){
        Optional<Integer> id = matchRepository.findMaxId();

        return UsernamePasswordTO.newBuilder()
                .withUsername("user" + id.map(i -> i+1).orElse(1))
                .withPassword("secret")
                .build();
    }
}
