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
public class DaysDao extends AbstractDao implements DataAccessObject<Days> {

    public DaysDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Days days) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql =
                    "insert into Days (days) "
                            + "values (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setObject(1, days.getDays());
                statement.setObject ( 2, days.getDate () );
                statement.executeUpdate();

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    days.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Talks retrieve (Long id) throws SQLException{
        return retrieveSingleObject ( "SELECT * FROM days WHERE id = ?", this::mapToDays, id);
    }

    @Override
    public List<Talks> listAll() throws SQLException {
        return list("select * from courses", this::mapToDays);
    }


    public Days mapToDays(ResultSet rs) throws SQLException{
        Days days = new Days ();
        days.setId ( rs.getLong ( "id" ) );
        days.setDays ( rs.getString ( "days" ) );
        days.setDate ( rs.getString ( "date" ) );
        return days;
    }


}
