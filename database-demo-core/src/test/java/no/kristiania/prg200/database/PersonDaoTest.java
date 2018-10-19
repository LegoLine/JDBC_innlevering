package no.kristiania.prg200.database;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

public class PersonDaoTest {

    @Test
    public void shouldFindSavedPersons() throws SQLException, IOException {
        Person person = samplePerson();
        personDao.save(person);
        assertThat(personDao.listAll())
            .contains(person);
    }

    @Test
    public void shouldRetrievePersonById() throws IOException, SQLException {
        Person person = samplePerson();
        personDao.save(person);

        assertThat(person.getId()).isNotNull();
        assertThat(personDao.retrieve(person.getId()))
            .isEqualToComparingFieldByField(person);
    }

    private Person samplePerson() {
        Person person = new Person();
        person.setGivenName(pickOne(new String[] { "John", "Paul", "George", "Ringo" }));
        person.setFamilyName(pickOne(new String[] { "Lennon", "McCartney", "Harrison", "Starr" }));
        person.setEmail(
                person.getGivenName() + "." + person.getFamilyName() + "@example.com");
        return person;
    }

    private String pickOne(String[] alternatives) {
        return alternatives[random.nextInt(alternatives.length)];
    }

    private static Random random = new Random();

    private PersonDao personDao = new PersonDao(TestDataSource.createTestDataSource());
}
