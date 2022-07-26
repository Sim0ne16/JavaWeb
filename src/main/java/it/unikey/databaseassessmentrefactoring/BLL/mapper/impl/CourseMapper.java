package it.unikey.databaseassessmentrefactoring.BLL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseDTO;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.abstracts.GenericMapper;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends GenericMapper<CourseEntity, CourseDTO> {
}
