package it.unikey.databaseassessmentrefactoring.PL.controller;


import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseRatingDTO;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.CourseRatingService;
import it.unikey.databaseassessmentrefactoring.PL.mapper.impl.CourseRatingRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.CourseRatingRest;
import it.unikey.databaseassessmentrefactoring.PL.rest.StudentRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course-rating")
public class CourseRatingController {

    private final CourseRatingRestMapper mapper;
    private final CourseRatingService service;


    @GetMapping
    private ResponseEntity<List<CourseRatingRest>> getAllCourse(){
        List<CourseRatingDTO> courses = service.getAll();
        return new ResponseEntity<>(mapper.fromDtoListToRestList(courses), HttpStatus.OK);
    }



    @PostMapping
    private ResponseEntity<CourseRatingRest> post(@RequestBody CourseRatingRest course){

        CourseRatingDTO courseDTO = service.insert(mapper.fromRestToDto(course));
        CourseRatingRest courseRatingRest= mapper.fromDtoToRest(courseDTO);
        return new ResponseEntity<>(courseRatingRest,HttpStatus.OK);

    }

    //Il verbo Put indica un update dell'entità nel database, a differenza della Post dobbiamo gestire l'eccezzione
    //che abbiamo specificato nel service
    @PutMapping
    private ResponseEntity<CourseRatingRest> putCourse (@RequestBody CourseRatingRest course){

        try {
            CourseRatingDTO courseDTO = service.update(mapper.fromRestToDto(course));
            CourseRatingRest courseRest = mapper.fromDtoToRest(courseDTO);
            return new ResponseEntity<>(courseRest,HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
