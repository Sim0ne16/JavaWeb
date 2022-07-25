package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRatingRepository extends JpaRepository<CourseRatingEntity,Integer> {
}
