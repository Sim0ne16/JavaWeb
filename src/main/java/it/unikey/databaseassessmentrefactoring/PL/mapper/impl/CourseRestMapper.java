package it.unikey.databaseassessmentrefactoring.PL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseDTO;
import it.unikey.databaseassessmentrefactoring.PL.mapper.abstracts.GenericRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.CourseRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseRestMapper extends GenericRestMapper<CourseDTO, CourseRest> {
}
