package mispis.Tests;

import mispis.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;
    private Date startDate;
    private Date endDate;

    @BeforeEach
    void setUp() {
        startDate = new Date(123456789);
        endDate = new Date(987654321);
        project = new Project("Тестовый проект", startDate, endDate);
    }

    @Test
    void testDefaultConstructor() {
        Project defaultProject = new Project();
        assertNull(defaultProject.name);
        assertNull(defaultProject.start);
        assertNull(defaultProject.end);
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("Тестовый проект", project.getName());
        assertEquals(startDate, project.getStart());
        assertEquals(endDate, project.getEnd());
    }

    @Test
    void testSettersAndGetters() {
        Date newStart = new Date(111111111);
        Date newEnd = new Date(999999999);
        project.setName("Обновленный проект");
        project.setStart(newStart);
        project.setEnd(newEnd);

        assertEquals("Обновленный проект", project.getName());
        assertEquals(newStart, project.getStart());
        assertEquals(newEnd, project.getEnd());
    }

    @Test
    void testMakeNewProjectData() {
        Date newStart = new Date(555555555);
        Date newEnd = new Date(666666666);
        assertDoesNotThrow(() -> project.makeNewProjectData(newStart, newEnd)); //проверяем, что вызов метода makeNewProjectData не выбрасывает исключений.
    }

    @Test
    void testToString() {
        String expected = "Project{name='Тестовый проект', start=" + startDate + ", end=" + endDate + "}";
        assertEquals(expected, project.toString());
    }
}
