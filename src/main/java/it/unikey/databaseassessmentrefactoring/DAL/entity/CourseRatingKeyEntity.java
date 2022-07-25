package it.unikey.databaseassessmentrefactoring.DAL.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseRatingKeyEntity implements Serializable {

    @Column(name = "student_id")
    Integer studentId;

    @Column(name = "course_id")
    Integer courseId;



}
