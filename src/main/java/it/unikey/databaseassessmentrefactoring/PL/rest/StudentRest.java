package it.unikey.databaseassessmentrefactoring.PL.rest;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentRest {

    private Integer id;

    private String name;

    private String lastName;



}
