package tn.esprit.spring.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.services.IInstructorServices;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorRestController {

    private final IInstructorServices instructorServices;
    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return  instructorServices.addInstructor(instructor);
    }
    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorServices.updateInstructor(instructor);
    }
    @GetMapping("/getById/{id}")
    public Instructor retrieveInstructorById(@PathVariable("id") Long id) {
        return instructorServices.retrieveInstructorById(id);
    }
    @GetMapping("/all")
    public List<Instructor> retrieveAllInstructor() {
        return instructorServices.retrieveAllInstructor();
    }
    @DeleteMapping("/delete")
    public  void deleteInstructor(@RequestBody Instructor instructor){
        instructorServices.deleteInstructor(instructor);
    }


}
