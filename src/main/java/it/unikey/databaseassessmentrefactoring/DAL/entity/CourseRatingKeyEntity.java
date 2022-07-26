package it.unikey.databaseassessmentrefactoring.DAL.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CourseRatingKeyEntity implements Serializable {

    @Column(name = "student_id")
    Integer studentId;

    @Column(name = "course_id")
    Integer courseId;



}
