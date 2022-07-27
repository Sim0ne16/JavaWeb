package it.unikey.databaseassessmentrefactoring.DAL.entity;


import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "CourseRating")
@Getter
@Setter
public class CourseRatingEntity {

    @EmbeddedId
    CourseRatingKeyEntity id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    StudentEntity student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    CourseEntity course;

    private Integer rating;



}
