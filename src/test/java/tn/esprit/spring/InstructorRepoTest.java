package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;

import java.util.List;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstructorRepoTest {
    @Autowired
    IInstructorRepository instructorRepository;

    static Instructor i=Instructor.builder().firstName("oumeyma").lastName("nefzi").dateOfHire(null).build();

    @Test
    @Order(0)
    public void testInstructorCreation() {
        i=instructorRepository.save(i);
        log.info("Ajout ==>", i);
        Assertions.assertNotNull(i.getNumInstructor());
        Assertions.assertNotEquals(0,i.getNumInstructor());
    }
    @Test
    @Order(1)
    public void testInstructorModification() {
        i.setFirstName("mohamed");
        i=instructorRepository.save(i);
        log.info("Modif ==>",i.toString());
        Assertions.assertNotEquals("oumeyma",i.getFirstName());
        Assertions.assertSame("mohamed",i.getFirstName());
    }
    @Test
    @Order(2)
    public void testInstructorListe() {
        List<Instructor> list =instructorRepository.findAll();
        log.info("Liste ==>",list.size());
        Assertions.assertTrue(list.size()>0 );
    }
    @Test
    @Order(3)
    public void testInstructorChercher() {
        log.info("cherche Instructor avec ID ==>",i.getNumInstructor());
        Instructor i1 = instructorRepository.findById(i.getNumInstructor()).get();
        Assertions.assertEquals(i1.getFirstName(),i.getFirstName());

    }
    @Test
    @Order(4)
    public void testInstructorSupprimer() {
        instructorRepository.deleteById(i.getNumInstructor());
        Instructor i1 = instructorRepository.findById(i.getNumInstructor()).orElse(null);
        Assertions.assertNull(i1);
        log.info("Supprimer");
    }
}
