package no.kristiania.prg200.database;

import no.kristiania.prg200.database.core.Days;
import no.kristiania.prg200.database.core.DaysDao;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

public class DaysDaoTest {

    private DaysDao daysDao = new DaysDao ( TestDataSource.createDataSource() );

    @Test
    public void shouldCreateDays() throws SQLException{
        Days days = sampleDays();
        daysDao.save ( days );
        assertThat(days).hasNoNullFieldsOrProperties();
        assertThat (daysDao.retrieve (days.getId()))
            .isEqualToComparingFieldByField(days);
    }

    private Days sampleDays() {
        return null;
    }


}
