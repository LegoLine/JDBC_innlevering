package no.kristiania.prg200.database.main;

import no.kristiania.prg200.database.core.Days;
import no.kristiania.prg200.database.core.DaysDao;
import no.kristiania.prg200.database.core.Talks;
import no.kristiania.prg200.database.core.TalksDao;
import no.kristiania.prg200.database.*;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;


public class Conference {

    public static void main(String[] args) throws IOException, SQLException {
        DataSource dataSource = createDataSource();
//        DaysDao daysDao = new DaysDao(dataSource);
//
//        Days testDays = new Days();
//        testDays.setDate("29.01.1993");
//        testDays.setDays("Friday");
//        testDays.setId(1L);
//        daysDao.save(testDays);
//
//        System.out.println (testDays);

        //createConference();


    }

    private static void createConference() {

    }

    private static DataSource createDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setURL("jdbc:postgresql://localhost:5433/jdbc_innlevering");
        dataSource.setUser("postgres");
        dataSource.setPassword("root");

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.migrate();
        flyway.clean();

        return dataSource;
    }
}
