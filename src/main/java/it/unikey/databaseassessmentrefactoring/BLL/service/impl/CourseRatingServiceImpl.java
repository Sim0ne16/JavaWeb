package it.unikey.databaseassessmentrefactoring.BLL.service.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingDTO;
import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingKeyDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.impl.CourseRatingMapper;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.CourseRatingService;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseRatingEntity;
import it.unikey.databaseassessmentrefactoring.DAL.repository.CourseRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseRatingServiceImpl implements CourseRatingService {

    private final CourseRatingMapper mapper;
    private final CourseRatingRepository repository;

    @Override
    public CourseRatingDTO insert(CourseRatingDTO dto) {
       return mapper.fromEntityToDto(repository.save(mapper.fromDtoToEntity(dto)));
    }

    @Override
    public CourseRatingDTO getById(Integer id) throws NotFoundException {
      return mapper.fromEntityToDto(repository.findById(id).orElseThrow(()->new NotFoundException("not found")));
    }

    @Override
    public CourseRatingDTO getById(CourseRatingKeyDTO id) throws NotFoundException {
        return mapper.fromEntityToDto((CourseRatingEntity) repository.findById(id).orElseThrow(()->new NotFoundException("not found")));
    }



    @Override
    public List<CourseRatingDTO> getAll() {
        return mapper.fromEntityListToDtoList(repository.findAll());
    }



    @Override
    public CourseRatingDTO update(CourseRatingDTO dto) throws NotFoundException {
      //aggiunto un metodo existsById con chiave CourseRatingKeyDto nella repository
        if(!repository.existsById(dto.getId()))
            throw new NotFoundException("not found");
        CourseRatingEntity courseUpdated = repository.save(mapper.fromDtoToEntity(dto));
        return mapper.fromEntityToDto(courseUpdated);

    }




    @Override
    public void delete(CourseRatingDTO dto) throws NotFoundException {
        if(!repository.existsById(dto.getId())){
            throw new NotFoundException("not found");
        }
        repository.delete(mapper.fromDtoToEntity(dto));

    }



}
