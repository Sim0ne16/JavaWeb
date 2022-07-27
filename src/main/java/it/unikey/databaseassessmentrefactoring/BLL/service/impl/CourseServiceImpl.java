package it.unikey.databaseassessmentrefactoring.BLL.service.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.impl.CourseMapper;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.CourseService;
import it.unikey.databaseassessmentrefactoring.DAL.entity.CourseEntity;
import it.unikey.databaseassessmentrefactoring.DAL.repository.CourseRepository;
import it.unikey.databaseassessmentrefactoring.PL.rest.CourseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper mapper;
    private final CourseRepository repository;

    @Override
    public List<CourseDTO> getCoursesByNameAndDuration(String name, Double duration) throws NotFoundException {
        if(!repository.existsByNameAndDuration(name,duration)){
            throw new NotFoundException("not found");
        }
        List<CourseEntity> entity = repository.findByNameAndDuration(name, duration);
        return mapper.fromEntityListToDtoList(entity);
    }

    @Override
    public CourseDTO insert(CourseDTO dto) {
        CourseEntity entity = mapper.fromDtoToEntity(dto);
        CourseEntity entitySaved = repository.save(entity);
        return mapper.fromEntityToDto(entitySaved);
    }

    @Override
    public CourseDTO getById(Integer id) throws NotFoundException {
        CourseEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
        return mapper.fromEntityToDto(entity);
    }

    @Override
    public List<CourseDTO> getAll() {
        List<CourseEntity> courses = repository.findAll();
        return mapper.fromEntityListToDtoList(courses);
    }

    @Override
    public CourseDTO update(CourseDTO dto) throws NotFoundException {
        if (!repository.existsById(dto.getId())) {
            throw new NotFoundException("not found");
        }
        CourseEntity courseUpdated = repository.save(mapper.fromDtoToEntity(dto));
        return mapper.fromEntityToDto(courseUpdated);
    }

    @Override
    public void delete(CourseDTO dto) throws NotFoundException {
        if(!repository.existsById(dto.getId())){
            throw new NotFoundException("not found");
        }
        repository.deleteById(dto.getId());

    }



}
