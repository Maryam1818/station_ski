package tn.esprit.spring.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.dto.CourseDTO;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JunitCourseServicesImplTest {


    @Autowired
    ICourseServices courseService;

    @Test
    @Order(1)
    void addUpdateCourse() {
        CourseDTO cour = new CourseDTO();
        cour.setLevel(80);
        cour.setSupport(Support.SKI);
        CourseDTO course = courseService.addUpdateCourse(cour);
        assertNotNull(course);
        assertEquals(80, course.getLevel());
        assertEquals(Support.SKI, course.getSupport());
        System.out.println("Add : Ok");
    }

    @Test
    @Order(2)
    void retrieveAllCourses() {
        List<Course> courses = courseService.retrieveAllCourses();

        // Assert that the returned list is not null
        assertNotNull(courses);

        // Assert that the returned list is not empty
        assertFalse(courses.isEmpty());

        // You can add more specific assertions based on your requirements
        System.out.println("RetrieveAllCoursesTest : Ok");
    }

    @Test
    @Order(3)
    void retrieveCourse() {
        // Assuming courseService.retrieveCourse method returns a Course
        Course course = courseService.retrieveCourse(1L); // Replace 1 with the actual ID you want to retrieve

        // Add assertions based on your requirements
        assertNotNull(course);

        // Additional assertions...
        System.out.println("RetrieveCourseTest : Ok");

    }
}