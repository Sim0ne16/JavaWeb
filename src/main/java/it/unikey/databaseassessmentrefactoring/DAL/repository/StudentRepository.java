package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.DAL.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    boolean existsByNameAndLastName(String name, String lastName);

    List<StudentEntity> findByNameAndLastName(String name, String lastName);
}
