package be.qnh.gertronic.snooker.action.mother;

import be.qnh.gertronic.snooker.action.to.PlayerTO;
import be.qnh.gertronic.snooker.action.to.MatchTO;

import java.time.LocalDate;
import java.time.Month;

public class MatchCreator {

    public static MatchTO createDefault(){
        return MatchTO.newBuilder()
                .withDatePlayed(LocalDate.of(2018, Month.JANUARY, 15))
                .withNumberOfFrames(5)
                .withPlayer1(PlayerTO.newBuilder().withFirstName("Tom").withLastName("Scott").build())
                .withPlayer2(PlayerTO.newBuilder().withFirstName("David").withLastName("Gramm").build())
                .build();
    }
}
