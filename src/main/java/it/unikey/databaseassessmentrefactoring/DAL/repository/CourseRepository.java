package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    List<CourseEntity> findByNameAndDuration(String name, Double duration);

    boolean existsByNameAndDuration(String name, Double duration);
}
