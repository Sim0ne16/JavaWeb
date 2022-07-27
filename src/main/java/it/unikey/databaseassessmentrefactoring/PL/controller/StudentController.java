package it.unikey.databaseassessmentrefactoring.PL.controller;


import it.unikey.databaseassessmentrefactoring.BLL.DTO.StudentDTO;
import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.StudentService;
import it.unikey.databaseassessmentrefactoring.PL.mapper.impl.StudentRestMapper;
import it.unikey.databaseassessmentrefactoring.PL.rest.StudentRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;
    private final StudentRestMapper mapper;


    //Con il verbo Get indichiamo la ricezione di dati dal Database
    @GetMapping
    private ResponseEntity<List<StudentRest>> getAllStudents() {
        List<StudentDTO> studentsDTO = service.getAll();
        List<StudentRest> StudentRest = mapper.fromDtoListToRestList(studentsDTO);
        return new ResponseEntity<>(StudentRest, HttpStatus.OK);
    }


    //Andando a specificare un path con le {} indichiamo la presenza di un pathvariable, che possiamo passare poi come
    //parametro nel metodo --> in questo caso {id}
    @GetMapping(path = "/{id}")
    private ResponseEntity<StudentRest> getStudentById(@PathVariable Integer id) {

        try {
            StudentDTO student = service.getById(id);
            StudentRest studentRest = mapper.fromDtoToRest(student);
            return new ResponseEntity<>(studentRest, HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(path = "/{name}/{lastName}")
    private ResponseEntity<List<StudentRest>> getByNameAndLastName(@PathVariable("name") String name, @PathVariable("lastName") String lastName) {

        try {
            List<StudentDTO> dtoList = service.getByNameAndLastName(name, lastName);
            List<StudentRest> studentRests = mapper.fromDtoListToRestList(dtoList);
            return new ResponseEntity<>(studentRests, HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Stesso metodo precedente ma con utilizzo di QueryParam invece che PathVariable, il query Param a differenza del
    //path variable prevede coding ed encoding, quindi può prevedere degli spazi a differenza del path variable
    //esempio di sintassi di chiamata -> http://localhost:8080/athlete/fullname?name=Simone&lastName=Giampa
    @GetMapping(path = "/fullname")
    private ResponseEntity<List<StudentRest>> getByFullName(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName) {
        {

            try {
                List<StudentDTO> dtoList = service.getByNameAndLastName(name, lastName);
                List<StudentRest> studentRests = mapper.fromDtoListToRestList(dtoList);
                return new ResponseEntity<>(studentRests, HttpStatus.OK);
            } catch (NotFoundException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }


    //Il vero Post indica un inserimento di dati nel database, dobbiamo fornire un Body nella richiesta e l'annotations
    //@RequestBody server per convertire il Json che arriva in una classe comprensibile a Java, i campi nel Json devono
    //corrispondere ai campi che abbiamo definito nella classe java (in questo caso la classe AthleteRest)

    @PostMapping
    private ResponseEntity<StudentRest> postStudent (@RequestBody StudentRest student){

        StudentDTO studentsDTO = service.insert(mapper.fromRestToDto(student));
        StudentRest studentRest = mapper.fromDtoToRest(studentsDTO);
        return new ResponseEntity<>(studentRest,HttpStatus.OK);

    }

    //Il verbo Put indica un update dell'entità nel database, a differenza della Post dobbiamo gestire l'eccezzione
    //che abbiamo specificato nel service
    @PutMapping
    private ResponseEntity<StudentRest> putStudent (@RequestBody StudentRest student){

        try {
            StudentDTO studentDTO = service.update(mapper.fromRestToDto(student));
            StudentRest studentRest = mapper.fromDtoToRest(studentDTO);
            return new ResponseEntity<>(studentRest,HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Con il verbo Delete indichiamo l'eliminazione di un'entità nel database
    @DeleteMapping(path = "/{id}")
    private ResponseEntity<StudentRest> deleteStudent(@PathVariable StudentRest id){

        try {
            service.delete(mapper.fromRestToDto(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}