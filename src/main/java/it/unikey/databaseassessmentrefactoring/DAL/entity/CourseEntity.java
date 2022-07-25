package it.unikey.databaseassessmentrefactoring.DAL.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Course")
@Getter
@Setter
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name;

    @Column(nullable = false)
    @NonNull
    private Integer duration ;

    @OneToMany(mappedBy = "course")
    Set<CourseRatingEntity> ratings;

}
