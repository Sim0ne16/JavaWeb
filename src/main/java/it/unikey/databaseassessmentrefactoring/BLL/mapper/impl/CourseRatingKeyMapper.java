package it.unikey.databaseassessmentrefactoring.BLL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.abstracts.GenericMapper;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingKeyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseRatingKeyMapper extends GenericMapper<CourseRatingKeyEntity, CourseRatingKeyDTO> {



}
