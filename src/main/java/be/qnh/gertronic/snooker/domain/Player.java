package be.qnh.gertronic.snooker.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by stijn on 17/01/2018.
 */
@Entity
@Table(name = "PLAYER")
public class Player extends AbstractEntity{
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastname;

    //default coonstructor required for JPA
    protected Player() {

    }

    private Player(Builder builder) {
        setFirstname(builder.firstname);
        setLastname(builder.lastname);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public static final class Builder {
        private String firstname;
        private String lastname;

        private Builder() {
        }

        public Builder withFirstname(String val) {
            firstname = val;
            return this;
        }

        public Builder withLastname(String val) {
            lastname = val;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
