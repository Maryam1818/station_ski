package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.services.ICourseServices;

import java.util.List;

@Tag(name = "\uD83D\uDCDA Course Management")
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseRestController {
    


}
