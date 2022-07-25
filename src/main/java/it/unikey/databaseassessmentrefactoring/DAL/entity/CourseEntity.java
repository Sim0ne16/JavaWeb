package it.unikey.databaseassessmentrefactoring.DAL.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name;

    @Column(nullable = false)
    @NonNull
    private Integer duration ;

    @OneToMany(mappedBy = "Course")
    Set<CourseRatingEntity> ratings;

}
