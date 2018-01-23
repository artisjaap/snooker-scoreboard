package be.qnh.gertronic.snooker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by stijn on 17/01/2018.
 */
public interface MatchRepository extends JpaRepository<Match, Integer> {

    @Query("select max(id) from Match")
    Optional<Integer> findMaxId();

    Optional<Match> findByUsernameAndPassword(String username, String password);
}
