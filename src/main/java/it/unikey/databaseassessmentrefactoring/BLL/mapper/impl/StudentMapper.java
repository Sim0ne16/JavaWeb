package it.unikey.databaseassessmentrefactoring.BLL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.abstracts.GenericMapper;
import it.unikey.databaseassessmentrefactoring.DAL.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericMapper<StudentEntity, StudentDTO> {
}
