package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.DAL.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
