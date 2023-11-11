package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IInstructorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class InstructorServicesImpl implements IInstructorServices{
    IInstructorRepository instructorRepository;
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Instructor> retrieveAllInstructor() {
        return instructorRepository.findAll();
    }
    @Override
    public  void deleteInstructor(Instructor instructor){
        instructorRepository.delete(instructor);
    }

}
