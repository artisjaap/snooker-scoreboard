package be.qnh.gertronic.snooker.action.to;

/**
 * Created by stijn on 10/02/18.
 */
public class BreakTO {
    private final Integer red;
    private final Integer yellow;
    private final Integer green;
    private final Integer brown;
    private final Integer blue;
    private final Integer pink;
    private final Integer black;
    private final Integer total;

    public Integer getRed() {
        return red;
    }

    public Integer getYellow() {
        return yellow;
    }

    public Integer getGreen() {
        return green;
    }

    public Integer getBrown() {
        return brown;
    }

    public Integer getBlue() {
        return blue;
    }

    public Integer getPink() {
        return pink;
    }

    public Integer getBlack() {
        return black;
    }

    public Integer getTotal() {
        return total;
    }

    private BreakTO(Builder builder) {
        red = builder.red;
        yellow = builder.yellow;
        green = builder.green;
        brown = builder.brown;
        blue = builder.blue;
        pink = builder.pink;
        black = builder.black;
        total = builder.total;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer red;
        private Integer yellow;
        private Integer green;
        private Integer brown;
        private Integer blue;
        private Integer pink;
        private Integer black;
        private Integer total;

        private Builder() {
        }

        public Builder withRed(Integer val) {
            red = val;
            return this;
        }

        public Builder withYellow(Integer val) {
            yellow = val;
            return this;
        }

        public Builder withGreen(Integer val) {
            green = val;
            return this;
        }

        public Builder withBrown(Integer val) {
            brown = val;
            return this;
        }

        public Builder withBlue(Integer val) {
            blue = val;
            return this;
        }

        public Builder withPink(Integer val) {
            pink = val;
            return this;
        }

        public Builder withBlack(Integer val) {
            black = val;
            return this;
        }

        public Builder withTotal(Integer val) {
            total = val;
            return this;
        }

        public BreakTO build() {
            return new BreakTO(this);
        }
    }
}
