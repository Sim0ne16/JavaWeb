package it.unikey.databaseassessmentrefactoring.DAL.entity;


import javax.persistence.*;

@Entity(name = "CourseRating")
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




}
