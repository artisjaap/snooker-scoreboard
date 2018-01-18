package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.InMemoryTest;
import be.qnh.gertronic.snooker.action.mother.MatchCreator;
import be.qnh.gertronic.snooker.action.to.MatchTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import be.qnh.gertronic.snooker.domain.Player;
import be.qnh.gertronic.snooker.domain.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreateMatchInMemoryTest extends InMemoryTest {

    @Autowired
    private CreateMatch createMatch;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;


    @Test
    public void createAnewMatch() {
        MatchTO matchTO = MatchCreator.createDefault();
        createMatch.voor(matchTO);

        List<Match> matches = matchRepository.findAll();
        Assert.assertEquals(1, matches.size());

        List<Player> players = playerRepository.findAll();
        Assert.assertEquals(2, players.size());

    }
}
