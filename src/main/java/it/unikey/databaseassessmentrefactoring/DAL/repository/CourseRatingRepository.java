package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingEntity;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRatingRepository extends JpaRepository<CourseRatingEntity,Integer> {

    boolean existsById(CourseRatingKeyDTO id);

    Optional<Object> findById(CourseRatingKeyDTO id);
}
