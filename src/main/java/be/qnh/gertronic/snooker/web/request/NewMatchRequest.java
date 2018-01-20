package be.qnh.gertronic.snooker.web.request;

import be.qnh.gertronic.snooker.action.to.MatchTO;
import be.qnh.gertronic.snooker.action.to.PlayerTO;

import java.time.LocalDate;

/**
 * Created by stijn on 19/01/18.
 */
public class NewMatchRequest {
    private String firstNamePlayer1;
    private String lastNamePlayer1;
    private String firstNamePlayer2;
    private String lastNamePlayer2;
    private int numberOfFrames;

    public MatchTO convertToTO(){
        return MatchTO.newBuilder()
                .withDatePlayed(LocalDate.now())
                .withNumberOfFrames(numberOfFrames)
                .withPlayer1(PlayerTO.newBuilder().withFirstName(firstNamePlayer1).withLastName(lastNamePlayer1).build())
                .withPlayer2(PlayerTO.newBuilder().withFirstName(firstNamePlayer2).withLastName(lastNamePlayer2).build())
                .build();
    }

    public String getFirstNamePlayer1() {
        return firstNamePlayer1;
    }

    public void setFirstNamePlayer1(String firstNamePlayer1) {
        this.firstNamePlayer1 = firstNamePlayer1;
    }

    public String getLastNamePlayer1() {
        return lastNamePlayer1;
    }

    public void setLastNamePlayer1(String lastNamePlayer1) {
        this.lastNamePlayer1 = lastNamePlayer1;
    }

    public String getFirstNamePlayer2() {
        return firstNamePlayer2;
    }

    public void setFirstNamePlayer2(String firstNamePlayer2) {
        this.firstNamePlayer2 = firstNamePlayer2;
    }

    public String getLastNamePlayer2() {
        return lastNamePlayer2;
    }

    public void setLastNamePlayer2(String lastNamePlayer2) {
        this.lastNamePlayer2 = lastNamePlayer2;
    }

    public int getNumberOfFrames() {
        return numberOfFrames;
    }

    public void setNumberOfFrames(int numberOfFrames) {
        this.numberOfFrames = numberOfFrames;
    }


}
