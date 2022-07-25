package it.unikey.databaseassessmentrefactoring.BLL.service.abstracts;

import java.util.List;

public interface LocationService extends CrudService<LocationDTO>{

    List<LocationDTO> getByCountryName(String countryName);

}
