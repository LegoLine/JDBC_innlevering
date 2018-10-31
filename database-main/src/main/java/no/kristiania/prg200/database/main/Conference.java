package no.kristiania.prg200.database.main;

import no.kristiania.prg200.database.*;

import no.kristiania.prg200.database.core.Days;
import no.kristiania.prg200.database.core.DaysDao;
import no.kristiania.prg200.database.core.Tracks;
import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import org.xml.sax.ext.Locator2;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


public class Conference {

    public static void main(String[] args) throws IOException, SQLException {
        DataSource dataSource = createDataSource();
        DaysDao daysDao = new DaysDao(dataSource);
        dataSource.getConnection();

        Tracks tracks = new Tracks(dataSource);
        tracks.createStandardDays();
//        createProperties ();
//        createProperties2 ();
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

//    public static Properties createProperties(){
//        Properties properties = new Properties ();
//        try ( FileReader reader = new FileReader("innlevering.properties")) {
//            properties.load(reader);
//        } catch (IOException e){
//            System.out.println (e.getMessage ());
//        }
//        return properties;
//    }
//
//    public static void createProperties2(){
//        Properties properties = new Properties ();
//        try ( FileReader reader = new FileReader("innlevering.properties") ) {
//            properties.load(reader);
//        } catch (IOException e){
//            System.out.println (e.getMessage ());
//        }
//    }

}
