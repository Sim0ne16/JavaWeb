package it.unikey.databaseassessmentrefactoring.BLL.service.abstracts;

import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;

import java.util.List;

public interface CrudService<T> {

    T insert(T dto);

    T getById(Integer id) throws NotFoundException;

    List<T> getAll();

    T update(T dto) throws NotFoundException;

    //Posso passare anche un oggetto intero,approcci diversi

    void delete(T dto) throws NotFoundException;


}
