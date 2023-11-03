package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.spring.dto.CourseDTO;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.ICourseServices;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
class GestionStationSkiApplicationTests {

	@MockBean
	ICourseRepository courseRepository;

	@Autowired
	ICourseServices courseService;

	@MockBean
	private Course course;
	private List<Course> courses;

	@BeforeEach
	void setCourses() {
		courses = new ArrayList<>();

		Course course1 = new Course();
		course1.setNumCourse(1L);
		course1.setTypeCourse(TypeCourse.INDIVIDUAL);
		course1.setLevel(5);
		course1.setSupport(Support.SKI);
		course1.setPrice(150F);
		course1.setTimeSlot(16);
		courses.add(course1);

		Course course2 = new Course();
		course2.setNumCourse(5L);
		course2.setTypeCourse(TypeCourse.INDIVIDUAL);
		course2.setLevel(1);
		course2.setSupport(Support.SKI);
		course2.setPrice(200F);
		course2.setTimeSlot(456);
		courses.add(course2);
	}


	@Test
	void testretrieveAllCourses() {
		setCourses();
		when(courseRepository.findAll()).thenReturn(courses);
		List<Course> retrievecourse = courseService.retrieveAllCourses();
		assertEquals(courses, retrievecourse);
	}


	@Test
	void testaddCourse() {
		CourseDTO newCourseDto = new CourseDTO();
		newCourseDto.setNumCourse(15L);
		newCourseDto.setTypeCourse(TypeCourse.INDIVIDUAL);
		newCourseDto.setLevel(50);
		newCourseDto.setSupport(Support.SKI);
		newCourseDto.setPrice(250F);
		newCourseDto.setTimeSlot(160);

		when(courseRepository.save(any(Course.class))).thenAnswer(invocation -> {
			Course savedCourse= invocation.getArgument(0);
			savedCourse.setNumCourse(1L); // Set the ID as it would be generated during save
			return savedCourse;
		});

		CourseDTO addedCourseDto = courseService.addUpdateCourse(newCourseDto);

		verify(courseRepository).save(any(Course.class));

		assertEquals(TypeCourse.INDIVIDUAL, addedCourseDto.getTypeCourse());
		assertEquals(50, addedCourseDto.getLevel());
		assertEquals(Support.SKI, addedCourseDto.getSupport());
		assertEquals(250F, addedCourseDto.getPrice());
		assertEquals(160, addedCourseDto.getTimeSlot());
	}


	@Test
	void testUpdateCourse() {
		CourseDTO updatedCourseDto = new CourseDTO();
		updatedCourseDto.setNumCourse(15L);
		updatedCourseDto.setTypeCourse(TypeCourse.INDIVIDUAL);
		updatedCourseDto.setLevel(50);
		updatedCourseDto.setSupport(Support.SKI);
		updatedCourseDto.setPrice(250F);
		updatedCourseDto.setTimeSlot(160);

		when(courseRepository.save(any(Course.class))).thenAnswer(invocation -> invocation.getArgument(0));

		CourseDTO updatedCourseDtoResult = courseService.addUpdateCourse(updatedCourseDto);

		verify(courseRepository).save(any(Course.class));

		assertEquals(15L, updatedCourseDtoResult.getNumCourse());
		assertEquals(TypeCourse.INDIVIDUAL, updatedCourseDtoResult.getTypeCourse());
		assertEquals(50, updatedCourseDtoResult.getLevel());
		assertEquals(Support.SKI, updatedCourseDtoResult.getSupport());
		assertEquals(250F, updatedCourseDtoResult.getPrice());
		assertEquals(160, updatedCourseDtoResult.getTimeSlot());
	}



}
