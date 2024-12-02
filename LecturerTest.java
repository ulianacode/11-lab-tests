package mispis.Tests;

import mispis.Lecturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LecturerTest {

    private Lecturer lecturer;

    @BeforeEach
    void setUp() {
        lecturer = new Lecturer(12345, 5.5f, "Иван Иванов", "ivan@gmail.com", 2);
    }

    @Test
    void testDefaultConstructor() {
        // Arrange: настройка тестового окружения
        Lecturer defaultLecturer;

        // Act: вызов конструктора по умолчанию
        defaultLecturer = new Lecturer();

        // Assert: проверка значений по умолчанию
        assertEquals(0, defaultLecturer.ssNo);
        assertEquals(0, defaultLecturer.workExperience, 0.01);
        assertEquals("", defaultLecturer.name);
        assertEquals("", defaultLecturer.email);
        assertEquals(0, defaultLecturer.counter);
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange: настройка тестового окружения
        int expectedSsNo = 12345;
        float expectedWorkExperience = 5.5f;
        String expectedName = "Иван Иванов";
        String expectedEmail = "ivan@gmail.com";
        int expectedCounter = 2;

        // Act: объект уже создан в @BeforeEach

        // Assert: проверка параметров конструктора
        assertEquals(expectedSsNo, lecturer.ssNo);
        assertEquals(expectedWorkExperience, lecturer.workExperience, 0.01);
        assertEquals(expectedName, lecturer.name);
        assertEquals(expectedEmail, lecturer.email);
        assertEquals(expectedCounter, lecturer.counter);
    }

    @Test
    void testTakeTest() {
        // Assert: метод не должен выбрасывать исключение
        assertDoesNotThrow(lecturer::takeTest);
    }

    @Test
    void testTellTheMaterial() {

        // Assert: метод не должен выбрасывать исключение
        assertDoesNotThrow(lecturer::tellTheMaterial);
    }

    @Test
    void testToString() {
        // Arrange: настройка ожидаемого результата
        String expected = "Lecturer{ssNo=12345, workExperience=5.5, name='Иван Иванов', email='ivan@gmail.com', counter=2}";

        // Act: вызов метода toString()
        String actual = lecturer.toString();

        // Assert: проверка строкового представления
        assertEquals(expected, actual);
    }
}

