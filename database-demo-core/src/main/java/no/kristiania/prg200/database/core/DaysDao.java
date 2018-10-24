package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



/**
 * Tilsvarer courseDao
 */
public class DaysDao extends AbstractDao implements DataAccessObject {

    public DaysDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Tracks tracks) throws SQLException {
        try (Connection connection = dataSource.getConnection()){
            String sql = "insert into courses (title) "
                    + "values (?)";

            try (PreparedStatement statement =  connection.prepareStatement ( sql, PreparedStatement.RETURN_GENERATED_KEYS )){
                statement.setObject ( 1, Days.getDays());
                statement.executeUpdate ();

                try (ResultSet rs = statement.getGeneratedKeys ()){

                    rs.next ();
                    Days.setId(rs.getLong ( 1 ));
                }
            }
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
