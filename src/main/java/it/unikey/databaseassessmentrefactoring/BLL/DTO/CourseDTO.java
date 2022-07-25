package it.unikey.databaseassessmentrefactoring.BLL.DTO;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
public class CourseDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer duration;






}
