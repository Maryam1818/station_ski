package tn.esprit.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDTO {
    private Long numCourse;
    private int level;
    private TypeCourse typeCourse;
    private Support support;
    private Float price;
    private int timeSlot;
    @JsonIgnore
    private Set<Registration> registrations;

    public static Course toEntity(CourseDTO courseDto) {
        if (courseDto == null) {
            return null;
        }

        return Course.builder()
                .numCourse(courseDto.getNumCourse())
                .level(courseDto.getLevel())
                .support(courseDto.getSupport())
                .price(courseDto.getPrice())
                .timeSlot(courseDto.getTimeSlot())
                .build();
    }
}
