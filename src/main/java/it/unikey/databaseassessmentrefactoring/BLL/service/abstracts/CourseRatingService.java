package it.unikey.databaseassessmentrefactoring.BLL.service.abstracts;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingDTO;
import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;

public interface CourseRatingService extends CrudService<CourseRatingDTO> {


    void delete(CourseRatingDTO dto) throws NotFoundException;


    CourseRatingDTO getById(CourseRatingKeyDTO id) throws NotFoundException;



}
