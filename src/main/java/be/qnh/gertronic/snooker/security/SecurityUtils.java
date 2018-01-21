package be.qnh.gertronic.snooker.security;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * Created by stijn on 20/01/18.
 */
public class SecurityUtils {

    public static Optional<MatchDetails> findSessionData() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (MatchDetails.class.isAssignableFrom(details.getClass())) {
            return Optional.of((MatchDetails) details);
        }
        return Optional.empty();
    }
}
