package it.unikey.databaseassessmentrefactoring.BLL.service.abstracts;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;

import java.util.List;

public interface CourseService extends CrudService<CourseDTO> {
    List<CourseDTO> getCoursesByNameAndDuration(String name, Double duration) throws NotFoundException;
}
