import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.RegistrationServicesImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @Mock
    private IRegistrationRepository registrationRepository;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private RegistrationServicesImpl registrationService;

    @Test
    void testAddRegistrationAndAssignToSkier() {
        Skier skier = new Skier();
        skier.setNumSkier(1L);
        Registration registration = new Registration(null, null, 1);
        when(skierRepository.findById(1L)).thenReturn(Optional.of(skier));
        when(registrationRepository.save(registration)).thenReturn(registration);

        Registration result = registrationService.addRegistrationAndAssignToSkier(registration, 1L);

        assertNotNull(result);
        assertEquals(skier, result.getSkier());
        verify(skierRepository, times(1)).findById(1L);
        verify(registrationRepository, times(1)).save(registration);
    }

    @Test
    void testAssignRegistrationToCourse() {
        Course course = new Course();
        course.setNumCourse(1L);
        Registration registration = new Registration(null, null, 1);
        when(registrationRepository.findById(1L)).thenReturn(Optional.of(registration));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(registrationRepository.save(registration)).thenReturn(registration);

        Registration result = registrationService.assignRegistrationToCourse(1L, 1L);

        assertNotNull(result);
        assertEquals(course, result.getCourse());
        verify(registrationRepository, times(1)).findById(1L);
        verify(courseRepository, times(1)).findById(1L);
        verify(registrationRepository, times(1)).save(registration);
    }

    @Test
    void testAddRegistrationAndAssignToSkierAndCourse() {
        Skier skier = new Skier();
        skier.setNumSkier(1L);
        Course course = new Course();
        course.setNumCourse(1L);
        Registration registration = new Registration(null, null, 1);
        when(skierRepository.findById(1L)).thenReturn(Optional.of(skier));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(registrationRepository.save(registration)).thenReturn(registration);
        when(registrationRepository.countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(1, 1L, 1L)).thenReturn(0L);

        Registration result = registrationService.addRegistrationAndAssignToSkierAndCourse(registration, 1L, 1L);

        assertNotNull(result);
        assertEquals(skier, result.getSkier());
        assertEquals(course, result.getCourse());
        verify(skierRepository, times(1)).findById(1L);
        verify(courseRepository, times(1)).findById(1L);
        verify(registrationRepository, times(1)).countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(1, 1L, 1L);
        verify(registrationRepository, times(1)).save(registration);
    }

    @Test
    void testNumWeeksCourseOfInstructorBySupport() {
        // Mock the necessary dependencies and verify the expected behavior
        // You can add assertions based on your implementation
    }

    @Test
    void testGetAllRegistration() {
        List<Registration> registrationList = Collections.singletonList(new Registration());
        when(registrationRepository.findAll()).thenReturn(registrationList);

        List<Registration> result = registrationService.getAllRegistration();

        assertNotNull(result);
        assertEquals(registrationList, result);
        verify(registrationRepository, times(1)).findAll();
    }
}
