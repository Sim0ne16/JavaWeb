package it.unikey.databaseassessmentrefactoring.PL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingDTO;
import it.unikey.databaseassessmentrefactoring.PL.mapper.abstracts.GenericRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.CourseRatingRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseRatingRestMapping extends GenericRestMapper<CourseRatingDTO, CourseRatingRest> {
}
