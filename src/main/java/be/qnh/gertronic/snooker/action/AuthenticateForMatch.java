package be.qnh.gertronic.snooker.action;

import be.qnh.gertronic.snooker.action.to.NewMatchTO;
import org.springframework.stereotype.Component;

/**
 * Created by stijn on 20/01/18.
 */
@Component
public class AuthenticateForMatch {

    public NewMatchTO with(String username, String password){
        return NewMatchTO.newBuilder().build();
    }
}
