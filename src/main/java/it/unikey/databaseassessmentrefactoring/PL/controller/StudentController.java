package it.unikey.databaseassessmentrefactoring.PL.controller;


import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.StudentService;
import it.unikey.databaseassessmentrefactoring.PL.mapper.impl.StudentRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.StudentRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;
    private final StudentRestMapper mapper;

    @GetMapping
    private ResponseEntity<List<StudentRest>> getAllStudents(){
        List<StudentDTO> studentsDTO = service.getAll();
        List<StudentRest> StudentRest = mapper.fromDtoListToRestList(studentsDTO);
        return new ResponseEntity<>(StudentRest, HttpStatus.OK);
    }



    @GetMapping(path = "/{id}")
    private ResponseEntity<StudentRest> getStudentById(@PathVariable Integer id){

        try {
            StudentDTO student = service.getById(id);
            StudentRest studentRest = mapper.fromDtoToRest(student);
            return new ResponseEntity<>(studentRest,HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }




}
