package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
}
