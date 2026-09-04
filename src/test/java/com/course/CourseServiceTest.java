package com.course;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseServiceTest {

    private CourseService service;
    private Course cs301;
    private Course math101;

    @Before
    public void setUp() {
        service = new CourseService();
        cs301   = new Course("CS301",   "Data Structures", 3, 30);
        math101 = new Course("MATH101", "Calculus",        4, 25);
        service.saveCourse(cs301);
        service.saveCourse(math101);
    }

    @Test
    public void saveCourse_shouldReturnProvideData_whenCourseIsNull() {
        assertEquals("provide course data", service.saveCourse(null));
    }

    @Test
    public void saveCourse_shouldReturnAlreadyExists_whenCodeIsDuplicate() {
        String response = service.saveCourse(new Course("cs301", "Other", 3, 20));
        assertEquals("course already exists", response);
    }

    @Test
    public void saveCourse_shouldReturnInvalidCredits_whenCreditsAreTooLow() {
        assertEquals("invalid credits", service.saveCourse(new Course("CS999", "Test", 0, 20)));
    }

    @Test
    public void saveCourse_shouldReturnInvalidCredits_whenCreditsAreTooHigh() {
        assertEquals("invalid credits", service.saveCourse(new Course("CS999", "Test", 6, 20)));
    }

    @Test
    public void saveCourse_shouldReturnSavedSuccessfully_whenCourseIsValid() {
        assertEquals("course saved successfully",
                service.saveCourse(new Course("CS401", "Algorithms", 3, 30)));
    }

    @Test
    public void searchByCourseCode_shouldReturnCourse_whenCodeExists() {
        Course found = service.searchByCourseCode("CS301");
        assertNotNull(found);
        assertEquals("Data Structures", found.getCourseName());
        assertSame(cs301, found);
    }

    @Test
    public void searchByCourseCode_shouldReturnNull_whenCodeDoesNotExist() {
        assertNull(service.searchByCourseCode("CS999"));
    }

    @Test
    public void searchByCourseCode_shouldReturnNull_whenCodeIsNull() {
        assertNull(service.searchByCourseCode(null));
    }

    @Test
    public void deleteCourse_shouldReturnDeleted_whenCourseExists() {
        assertEquals("course deleted", service.deleteCourse("CS301"));
    }

    @Test
    public void deleteCourse_shouldReturnNotFound_whenCourseDoesNotExist() {
        assertEquals("course not found", service.deleteCourse("CS999"));
    }
}
