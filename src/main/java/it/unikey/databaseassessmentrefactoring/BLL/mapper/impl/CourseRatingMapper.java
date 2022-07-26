package it.unikey.databaseassessmentrefactoring.BLL.mapper.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingDTO;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.abstracts.GenericMapper;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingEntity;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface CourseRatingMapper extends GenericMapper<CourseRatingEntity, CourseRatingDTO> {


}
