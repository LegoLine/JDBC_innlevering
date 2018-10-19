package no.kristiania.prg200.database;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

public class CourseDaoTest {

    private CourseDao courseDao = new CourseDao(TestDataSource.createTestDataSource());

    @Test
    public void shouldCreateCourse() throws SQLException {
        Course course = sampleCourse();
        courseDao.save(course);
        assertThat(course).hasNoNullFieldsOrProperties();
        assertThat(courseDao.retrieve(course.getId()))
            .isEqualToComparingFieldByField(course);
    }

    @Test
    public void shouldIncludeSavedCourseInListAll() throws SQLException {
        Course course = sampleCourse();
        courseDao.save(course);
        assertThat(courseDao.listAll())
            .contains(course);
    }

    private Course sampleCourse() {
        Course course = new Course();
        course.setTitle(randomTitle());
        return course;
    }

    private String randomTitle() {
        return pickOne(new String[] { "Introduction to",  "Advanced", "Formal", "Higher order", "Intermediate" })
                + " "
                + pickOne(new String[] { "Philosophy", "Math", "Java", "Android", "Physics", "Web Design", "Psycholoy" })
                + " "
                + pickOne(new String[] { "for dummies", "for scientists", "for arts majors", "for beginners", "for lazy people" })
                ;
    }


    private String pickOne(String[] alternatives) {
        return alternatives[random.nextInt(alternatives.length)];
    }

    private static Random random = new Random();

}
