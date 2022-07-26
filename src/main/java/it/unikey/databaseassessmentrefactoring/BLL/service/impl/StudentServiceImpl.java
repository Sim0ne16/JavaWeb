package it.unikey.databaseassessmentrefactoring.BLL.service.impl;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.mapper.impl.StudentMapper;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.StudentService;
import it.unikey.databaseassessmentrefactoring.DAL.entity.StudentEntity;
import it.unikey.databaseassessmentrefactoring.DAL.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    public final StudentMapper mapper ;
    public final StudentRepository repository;

    @Override
    public StudentDTO insert(StudentDTO dto) {
        StudentEntity studentToSave = mapper.fromDtoToEntity(dto);
        StudentEntity studentSaved = repository.save(studentToSave);
        return mapper.fromEntityToDto(studentSaved);
    }

    @Override
    public StudentDTO getById(Integer id) throws NotFoundException {

        StudentEntity student = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return mapper.fromEntityToDto(student);

    }

    @Override
    public List<StudentDTO> getAll() {

        List<StudentEntity> students = repository.findAll();
        return mapper.fromEntityListToDtoList(students);

    }

    @Override
    public StudentDTO update(StudentDTO dto) throws NotFoundException {

        if(!repository.existsById(dto.getId())){

            throw new NotFoundException("not found");
        }
        StudentEntity studentUpdated = repository.save(mapper.fromDtoToEntity(dto));

        return (mapper.fromEntityToDto(studentUpdated));

    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!repository.existsById(id)){
            throw new NotFoundException("not found");
        }
        repository.deleteById(id);

    }

    @Override
    public List<StudentDTO> getByNameAndLastName(String name, String lastName) throws NotFoundException {
        if(!repository.existsByNameAndLastName(name,lastName))
            throw new NotFoundException("not found");
        List<StudentEntity> students = repository.findByNameAndLastName(name,lastName);
        return mapper.fromEntityListToDtoList(students);
    }
}
