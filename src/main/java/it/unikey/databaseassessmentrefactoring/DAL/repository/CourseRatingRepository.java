package it.unikey.databaseassessmentrefactoring.DAL.repository;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRatingEntity,Integer> {

    boolean existsById(CourseRatingKeyDTO id);

    Optional<Object> findById(CourseRatingKeyDTO id);
}
