package be.qnh.gertronic.snooker.web.response;

import be.qnh.gertronic.snooker.action.to.PlayerTO;

/**
 * Created by stijn on 19/01/18.
 */
public class PlayerResponse {
    private String firstName;
    private String lastName;

    protected PlayerResponse(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private PlayerResponse(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static PlayerResponse from(PlayerTO playerTO) {
        return PlayerResponse.newBuilder()
                .withFirstName(playerTO.firstName())
                .withLastName(playerTO.lastName())
                .build();
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

        public PlayerResponse build() {
            return new PlayerResponse(this);
        }
    }
}
