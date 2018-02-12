package be.qnh.gertronic.snooker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by stijn on 8/02/18.
 */

@Entity
@Table(name = "CURRENT_BREAK")
public class Break extends AbstractEntity{
    @Column(name = "RED")
    private int red = 0;
    @Column(name = "YELLOW")
    private int yellow = 0;
    @Column(name = "GREEN")
    private int green = 0;
    @Column(name = "BROWN")
    private int brown = 0;
    @Column(name = "BLUE")
    private int blue = 0;
    @Column(name = "PINK")
    private int pink = 0;
    @Column(name = "BLACK")
    private int black = 0;

    public static Break create() {
        return new Break();
    }

    public void reset() {
        red = yellow = green = brown = blue = pink = black = 0;
    }

    public void addScore(int score) {
        switch (score){
            case 1: red++; break;
            case 2: yellow++; break;
            case 3: green++; break;
            case 4: brown++; break;
            case 5: blue++; break;
            case 6: pink++; break;
            case 7: black++; break;
        }
    }

    public int score() {
        return red + yellow * 2 + green * 3 + brown * 4 + blue * 5 + pink * 6 + black * 7;
    }


    public int getRed() {
        return red;
    }

    public int getYellow() {
        return yellow;
    }

    public int getGreen() {
        return green;
    }

    public int getBrown() {
        return brown;
    }

    public int getBlue() {
        return blue;
    }

    public int getPink() {
        return pink;
    }

    public int getBlack() {
        return black;
    }
}
