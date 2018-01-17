package be.qnh.gertronic.snooker.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stijn on 17/01/2018.
 */
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
