package be.qnh.gertronic.snooker.action.to;

/**
 * Created by stijn on 20/01/18.
 */
public class UsernamePasswordTO {

    private final String username;
    private final String password;

    private UsernamePasswordTO(Builder builder) {
        username = builder.username;
        password = builder.password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public static final class Builder {
        private String username;
        private String password;

        private Builder() {
        }

        public Builder withUsername(String val) {
            username = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public UsernamePasswordTO build() {
            return new UsernamePasswordTO(this);
        }
    }
}
