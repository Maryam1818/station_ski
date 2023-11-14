package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;
import tn.esprit.spring.services.InstructorServicesImpl;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {
    @Mock
    IInstructorRepository instructorRepository;
    @InjectMocks
    private InstructorServicesImpl instructorServices;
    static Instructor instructor = Instructor.builder().firstName("oumeyma").lastName("nefzi").dateOfHire(null).build();
    @Test
    public void addInstructor() {
        Mockito.when(instructorRepository.save(Mockito.any(Instructor.class))).then(inv -> {
            Instructor i = inv.getArgument(0, Instructor.class);
            i.setNumInstructor(1L);
            return i;
        });
        log.info("Before : " + instructor.getNumInstructor());
        Instructor ins = instructorServices.addInstructor(instructor);
        Assertions.assertSame(ins, instructor);
        log.info("After : " + instructor.getNumInstructor());
        Mockito.verify(instructorRepository).save(instructor);;
    }
}
