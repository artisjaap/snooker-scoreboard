package be.qnh.gertronic.snooker.action;

public class PlayerTO {
    private String firstName;
    private String lastName;

    private PlayerTO(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }


    public static final class Builder {
        private String firstName;
        private String lastName;

        private Builder() {
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public PlayerTO build() {
            return new PlayerTO(this);
        }
    }
}
