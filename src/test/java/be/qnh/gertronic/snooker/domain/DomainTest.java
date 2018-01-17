package be.qnh.gertronic.snooker.domain;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by stijn on 17/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() {
        System.out.println();

    }

}
