package tn.esprit.spring.services;

import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.entities.Support;

import java.util.List;

public interface IInstructorServices {

    Instructor addInstructor(Instructor instructor);

    Instructor updateInstructor(Instructor instructor);

    Instructor retrieveInstructorById(Long id);

    List<Instructor> retrieveAllInstructor();

    void deleteInstructor(Instructor instructor);

}
