package py.com.jaha.api.general.domain.ports.out;

import java.util.List;
import py.com.jaha.api.general.domain.models.cities.City;

public interface CitiesRepositoryPort {

  List<City> getCities(String name, String state);
}
