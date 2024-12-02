package mispis.Tests;

import mispis.Dean;
import mispis.Department;
import mispis.Faculty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {

    private Faculty faculty;
    private Dean dean;
    private String facultyName;
    private Collection<Department> departments;

    @BeforeEach
    void setUp() {
        dean = new Dean("Декан Иванов");
        facultyName = "Факультет компьютерных наук";
        departments = new ArrayList<>() {{
            add(new Department("Кафедра информатики", null));
            add(new Department("Кафедра математики", null));
        }};
        faculty = new Faculty(dean, facultyName, departments);
    }

    @Test
    void testDefaultConstructor() {
        Faculty defaultFaculty = new Faculty();

        assertNull(defaultFaculty.getDean());
        assertNull(defaultFaculty.getName());
        assertNull(defaultFaculty.getDepartments());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals(dean, faculty.getDean());
        assertEquals(facultyName, faculty.getName());
        assertEquals(departments, faculty.getDepartments());
    }

    @Test
    void testSettersAndGetters() {

        // Arrange: настройка тестового окружения
        Dean newDean = new Dean("Декан Петров");
        String newFacultyName = "Инженерный факультет";
        Collection<Department> newDepartments = new ArrayList<>() {{
            add(new Department("Кафедра механики", null));
        }};

        // Act: выполнение тестируемого сценария
        faculty.setDean(newDean);
        faculty.setName(newFacultyName);
        faculty.setDepartments(newDepartments);

        // Assert: проверка результатов
        assertEquals(newDean, faculty.getDean());
        assertEquals(newFacultyName, faculty.getName());
        assertEquals(newDepartments, faculty.getDepartments());
    }


    @Test
    void testUpdateDean() {
        Dean newDean = new Dean("Декан Сидоров");
        assertDoesNotThrow(() -> faculty.updateDean(newDean));
    }

    @Test
    void testToString() {
        String expected = "Faculty{" +
                "dean=" + dean +
                ", name='" + facultyName + '\'' +
                ", departments=" + departments +
                '}';
        assertEquals(expected, faculty.toString());
    }
}
