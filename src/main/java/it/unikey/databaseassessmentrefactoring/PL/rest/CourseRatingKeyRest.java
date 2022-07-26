package it.unikey.databaseassessmentrefactoring.PL.rest;

import lombok.Data;


// Rest = Representational state transfer
@Data
public class CourseRatingKeyRest {

    Integer studentId;

    Integer courseId;
}
