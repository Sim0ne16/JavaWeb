package it.unikey.databaseassessmentrefactoring.PL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.PL.mapper.abstracts.GenericRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.StudentRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentRestMapper extends GenericRestMapper<StudentDTO, StudentRest> {
}
