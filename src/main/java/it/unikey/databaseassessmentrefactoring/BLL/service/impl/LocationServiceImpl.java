package it.unikey.databaseassessmentrefactoring.BLL.service.impl;

import it.unikey.databaseassessmentrefactoring.BLL.exception.NotFoundException;
import it.unikey.databaseassessmentrefactoring.BLL.service.abstracts.LocationService;
import it.unikey.databaseassessmentrefactoring.DAL.entity.LocationEntity;
import it.unikey.databaseassessmentrefactoring.DAL.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;
    private final LocationMapper mapper;

    @Override
    public LocationDTO insert(LocationDTO dto) {
       LocationEntity LocationEntityToSave = mapper.fromDtoToEntity(dto);
       LocationEntity LocationEntitySaved = repository.save(LocationEntityToSave);
       return mapper.fromEntityToDto(LocationEntitySaved);
    }


    @Override
    public LocationDTO getById(Integer id) throws NotFoundException {
       LocationEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }


    @Override
    public List<LocationDTO> getByCountryName(String countryName) throws NotFoundException {
        List<LocationDTO> list = mapper.fromEntityListToDtoList(repository.findLocationEntitiesByCountryName(countryName));
        if(!list.isEmpty())
            return list;
        throw new NotFoundException("Not found");

    }


    @Override
    public List<LocationDTO> getAll() {
        return null;
    }


    @Override
    public LocationDTO update(LocationDTO dto) throws NotFoundException {
        return null;
    }


    @Override
    public void delete(Integer id) throws NotFoundException {

    }


}
