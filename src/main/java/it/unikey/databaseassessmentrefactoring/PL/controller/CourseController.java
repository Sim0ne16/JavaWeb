package it.unikey.databaseassessmentrefactoring.PL.controller;

import it.unikey.databaseassessmentrefactoring.BLL.DTO.CourseDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.CourseService;
import it.unikey.databaseassessmentrefactoring.PL.mapper.impl.CourseRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.CourseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Specifichiamo che è un controller di tipo REST
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService service;
    private final CourseRestMapper mapper;


    @GetMapping
    private ResponseEntity<List<CourseRest>> getAllCourses() {
        List<CourseDTO> courses = service.getAll();
        return new ResponseEntity<>(mapper.fromDtoListToRestList(courses), HttpStatus.OK);
    }

    //pathvariable
    @GetMapping(path = "/{id}")
    private ResponseEntity<CourseRest> getCourse(@PathVariable Integer id) {
        try {
            CourseDTO course = service.getById(id);
            return new ResponseEntity<>(mapper.fromDtoToRest(course), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Se è più di uno è meglio specificare in questo modo
    @GetMapping(path = "/{name}/{duration}")
    private ResponseEntity<List<CourseRest>> getCoursesByNameAndDuration(@PathVariable("name") String name, @PathVariable("duration") Double duration) {
        try {
            List<CourseDTO> dtoList = service.getCoursesByNameAndDuration(name, duration);
            return new ResponseEntity<>(mapper.fromDtoListToRestList(dtoList), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //esempio di sintassi di chiamata -> http://localhost:8080/course/nameAndDuration?name=Chimica&duration=1234
    @GetMapping(path = "/nameAndDuration")
    private ResponseEntity<List<CourseRest>> getByNameAndDuration(
            @RequestParam("name") String name,
            @RequestParam("duration") Double duration) {

        try {
            List<CourseDTO> courses = service.getCoursesByNameAndDuration(name, duration);
            return new ResponseEntity<>(mapper.fromDtoListToRestList(courses), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    //update
    @PutMapping
    private ResponseEntity<CourseRest> putCourse (@RequestBody CourseRest course){

        try {
            CourseDTO courseDTO = service.update(mapper.fromRestToDto(course));
            return new ResponseEntity<>(mapper.fromDtoToRest(courseDTO),HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/id")
    private ResponseEntity<CourseRest> deleteCourse (@PathVariable CourseRest id){

        try {
            service.delete(mapper.fromRestToDto(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }






}
