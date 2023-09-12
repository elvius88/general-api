package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.cities;

import io.vavr.control.Try;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import py.com.jaha.api.general.domain.models.cities.City;
import py.com.jaha.api.general.domain.ports.out.CitiesRepositoryPort;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.cities.mapper.CitiesMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class CitiesRepositoryAdapter implements CitiesRepositoryPort {

  private final CitiesRepository citiesRepository;

  @Override
  public List<City> getCities(String name, String state) {
    return Try.of(() -> citiesRepository.findCitiesBy(name, state))
        .map(CitiesMapper.INSTANCE::toDomainList)
        .get();
  }
}
