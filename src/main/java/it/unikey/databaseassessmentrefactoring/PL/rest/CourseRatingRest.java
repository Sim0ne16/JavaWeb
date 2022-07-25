package it.unikey.databaseassessmentrefactoring.PL.rest;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;



@Data
public class CourseRatingRest {

    CourseRatingKeyDTO id;

    StudentRest student;

    CourseRest course;

}
