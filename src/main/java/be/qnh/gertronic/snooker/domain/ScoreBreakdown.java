package be.qnh.gertronic.snooker.domain;

/**
 * Created by stijn on 5/02/18.
 */
public class ScoreBreakdown {
    private int red = 0;
    private int yellow = 0;
    private int green = 0;
    private int brown = 0;
    private int blue = 0;
    private int pink = 0;
    private int black = 0;

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

    public ScoreBreakdown(int red, int yellow, int green, int brown, int blue, int pink, int black) {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.brown = brown;
        this.blue = blue;
        this.pink = pink;
        this.black = black;
    }

    public ScoreBreakdown minus(int value){
        switch (value){
            case 1: redMinus(); break;
            case 2: yellowMinus(); break;
            case 3: greenMinus(); break;
            case 4: brownMinus(); break;
            case 5: blueMinus(); break;
            case 6: pinkMinus(); break;
            case 7: blackMinus(); break;
        }
        return this;
    }

    public int pointsRemaining() {
        return red * 8 + yellow*2 + green*3 + brown*4 + blue*5 + pink*6 + black*7;
    }

    public void redMinus(){
        if(red == 0){
            red = 15;
        }else {
            red--;
        }
        reset(-1, 1, 1, 1, 1, 1, 1);
    }

    public void yellowMinus() {
        if (yellow == 0) {
            yellow = 1;
        } else {
            yellow = 0;
        }
        reset(0, -1, 1, 1, 1, 1, 1);
    }

    public void greenMinus() {
        if (green == 0) {
            green = 1;
        } else {
            green = 0;
        }
        reset(0, 0, -1, 1, 1, 1, 1);
    }

    public void brownMinus() {
        if (brown == 0) {
            brown = 1;
        } else {
            brown = 0;
        }
        reset(0, 0, 0, -1, 1, 1, 1);
    }

    public void blueMinus() {
        if (blue == 0) {
            blue = 1;
        } else {
            blue = 0;
        }
        reset(0, 0, 0, 0, -1, 1, 1);
    }

    public void pinkMinus() {
        if (pink == 0) {
            pink = 1;
        } else {
            pink = 0;
        }
        reset(0, 0, 0, 0, 0, -1, 1);
    }

    public void blackMinus() {
        if (pink == 0) {
            pink = 1;
        } else {
            pink = 0;
        }
        reset(0, 0, 0, 0, 0, 0, -1);
    }

    private void reset(int red, int yellow, int green, int brown, int blue, int pink, int black){
        this.red = red >= 0 ? red : this.red;
        this.yellow = yellow >= 0 ? yellow : this.yellow;
        this.green = green >= 0 ? green : this.green;
        this.brown = brown >= 0 ? brown : this.brown;
        this.blue = blue >= 0 ? blue : this.blue;
        this.pink = pink >= 0 ? pink : this.pink;
        this.black = black >= 0 ? black : this.black;
    }

    public static ScoreBreakdown from(int score){
        switch (score){
            case 27: return new ScoreBreakdown(0, 1, 1, 1, 1, 1, 1);
            case 25: return new ScoreBreakdown(0, 0, 1, 1, 1, 1, 1);
            case 22: return new ScoreBreakdown(0, 0, 0, 1, 1, 1, 1);
            case 18: return new ScoreBreakdown(0, 0, 0, 0, 1, 1, 1);
            case 13: return new ScoreBreakdown(0, 0, 0, 0, 0, 1, 1);
            case 7: return new ScoreBreakdown(0, 0, 0, 0, 0, 0, 1);
            default: return new ScoreBreakdown((score - 27) / 8, 1, 1, 1, 1, 1, 1);
        }
    }


}
