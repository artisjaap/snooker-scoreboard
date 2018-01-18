package be.qnh.gertronic.snooker;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class InMemoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    public void makeSureNextQueriesReloadDataFromDB() {
        entityManager.flush();
        entityManager.clear();
    }
}
