package it.unikey.databaseassessmentrefactoring.BLL.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;



@Data
public class CourseRatingDTO {

    @NotNull
    CourseRatingKeyDTO id;

    StudentDTO student;


    CourseDTO course;

}
