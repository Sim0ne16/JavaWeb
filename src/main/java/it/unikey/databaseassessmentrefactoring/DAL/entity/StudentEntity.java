package it.unikey.databaseassessmentrefactoring.DAL.entity;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;





@Entity(name = "Student")
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    private String lastName;

    private String surname;


    @OneToMany(mappedBy = "student")
    Set<CourseRatingEntity> ratings;

}
