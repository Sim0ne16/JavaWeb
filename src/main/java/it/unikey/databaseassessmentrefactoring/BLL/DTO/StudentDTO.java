package it.unikey.databaseassessmentrefactoring.BLL.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;



}
