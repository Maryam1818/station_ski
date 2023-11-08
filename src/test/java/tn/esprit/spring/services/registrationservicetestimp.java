package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.RegistrationServicesImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @InjectMocks
    private RegistrationServicesImpl registrationServices;

    @Mock
    private IRegistrationRepository registrationRepository;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ICourseRepository courseRepository;

    @Test
    public void testAddRegistration() {
        // Initialize Skier and Course with appropriate test data
        Skier skier = new Skier();
        skier.setNumSkier(1L); // Set the Skier's ID
        Course course = new Course();
        course.setNumCourse(2L); // Set the Course's ID

        Registration registration = new Registration(skier, course, 1);

        // Mock the behavior of skierRepository and courseRepository
        when(skierRepository.findById(1L)).thenReturn(Optional.of(skier));
        when(courseRepository.findById(2L)).thenReturn(Optional.of(course));

        // Mock the repository's save method
        when(registrationRepository.save(registration)).thenReturn(registration);

        Registration result = registrationServices.addRegistrationAndAssignToSkierAndCourse(registration, 1L, 2L);

        // Verify that the save method was called once
        verify(registrationRepository, times(1)).save(registration);

        // Verify that the result is not null
        assertNotNull(result);

        // Verify specific properties of the registration
        assertEquals(skier, result.getSkier());
        assertEquals(course, result.getCourse());
        assertEquals(1, result.getNumWeek()); // Verify other properties as needed
    }
}
