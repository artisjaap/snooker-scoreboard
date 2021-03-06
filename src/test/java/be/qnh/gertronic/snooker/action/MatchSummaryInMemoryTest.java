package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.InMemoryTest;
import be.qnh.gertronic.snooker.action.mother.MatchCreator;
import be.qnh.gertronic.snooker.action.to.FrameTO;
import be.qnh.gertronic.snooker.action.to.MatchSummaryTO;
import be.qnh.gertronic.snooker.action.to.MatchTO;
import be.qnh.gertronic.snooker.domain.Match;
import be.qnh.gertronic.snooker.domain.MatchRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class MatchSummaryInMemoryTest extends InMemoryTest {


    @Autowired
    private CreateMatch createMatch;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private AddFrameToMatch addFrameToMatch;

    @Autowired
    private MatchSummary matchSummary;

    @Test
    @Transactional
    public void createAnewMatch() {
        MatchTO matchTO = MatchCreator.createDefault();
        createMatch.voor(matchTO);

        List<Match> matches = matchRepository.findAll();
        Assert.assertEquals(1, matches.size());
        Integer matchId = matches.get(0).getId();

        FrameTO frameTo = FrameTO.newBuilder()
                .withScorePlayer1(20)
                .withScorePlayer2(50)
                .withFrameStart(LocalDateTime.now())
                .withFrameEnd(LocalDateTime.now())
                .build();
        addFrameToMatch.addFrame(matchId, frameTo);

        MatchSummaryTO matchSummaryTO = matchSummary.forMatch(matchId);
        Assert.assertEquals("Tom", matchSummaryTO.player1().firstName());
        Assert.assertEquals("Scott", matchSummaryTO.player1().lastName());
        Assert.assertEquals("David", matchSummaryTO.player2().firstName());
        Assert.assertEquals("Gramm", matchSummaryTO.player2().lastName());
        Assert.assertEquals(0, matchSummaryTO.framesWonPlayer1());
        Assert.assertEquals(1, matchSummaryTO.framesWonPlayer2());

    }
}
