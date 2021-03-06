package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.InMemoryTest;
import be.qnh.gertronic.snooker.action.mother.MatchCreator;
import be.qnh.gertronic.snooker.action.to.MatchTO;
import be.qnh.gertronic.snooker.action.to.NewMatchTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class StartNewGameInMemoryTest extends InMemoryTest {

    @Autowired
    private StartNewGame startNewGame;

    @Autowired
    private CreateMatch createMatch;

    @Test
    public void startNewGame(){
        MatchTO matchTO = MatchCreator.createDefault();
        NewMatchTO matchSummaryTO = createMatch.voor(matchTO);

        startNewGame.forMatch(matchSummaryTO.matchId());


    }
}
