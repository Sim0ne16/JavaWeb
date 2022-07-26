package it.unikey.databaseassessmentrefactoring.PL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import it.unikey.databaseassessmentrefactoring.PL.mapper.abstracts.GenericRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.CourseRatingKeyRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseRatingKeyRestMapper extends GenericRestMapper<CourseRatingKeyDTO,CourseRatingKeyRest> {
}
