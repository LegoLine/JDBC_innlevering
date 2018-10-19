package no.kristiania.prg200.database.core;

import java.sql.SQLException;
import java.util.List;

public interface DataAccessObject {

    void save(Tracks object) throws SQLException;

    Tracks retrieve(Long id) throws SQLException;

    List<Tracks> listAll() throws SQLException;

    void delete(Tracks object) throws SQLException;
}
