package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    List<CourseEntity> findByNameAndDuration(String name, Double duration);

    boolean existsByNameAndDuration(String name, Double duration);
}
