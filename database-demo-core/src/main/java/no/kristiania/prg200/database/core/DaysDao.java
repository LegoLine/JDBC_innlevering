package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



/**
 * Tilsvarer courseDao
 */
public class DaysDao implements DataAccessObject {

    public DaysDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Tracks tracks) throws SQLException {
        try (Connection connection = dataSource.getConnection){
            //kode
        }

    }

    @Override
    public Tracks retrieve(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Tracks> listAll() throws SQLException {
        return null;
    }

    @Override
    public void delete(Tracks object) throws SQLException {

    }
}
