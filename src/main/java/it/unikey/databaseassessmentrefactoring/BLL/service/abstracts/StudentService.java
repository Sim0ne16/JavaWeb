package it.unikey.databaseassessmentrefactoring.BLL.service.abstracts;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;

import java.util.List;

public interface StudentService extends CrudService<StudentDTO>{

    List<StudentDTO> getByNameAndLastName(String name, String lastName) throws NotFoundException;
}
