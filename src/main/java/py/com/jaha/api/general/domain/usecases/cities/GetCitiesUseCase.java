package py.com.jaha.api.general.domain.usecases.cities;

import static py.com.jaha.api.general.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.general.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.general.domain.commands.cities.GetCitiesCommand;
import py.com.jaha.api.general.domain.commands.cities.GetCitiesResponse;
import py.com.jaha.api.general.domain.ports.in.GetCitiesPort;
import py.com.jaha.api.general.domain.ports.out.CitiesRepositoryPort;
import py.com.jaha.api.general.domain.usecases.cities.mappers.GetCitiesResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetCitiesUseCase implements GetCitiesPort {

  private final CitiesRepositoryPort citiesRepositoryPort;

  @Override
  public GetCitiesResponse execute(GetCitiesCommand command) {
    return Try.of(() -> citiesRepositoryPort.getCities(command.getName(), command.getState()))
        .filter(cities -> !CollectionUtils.isEmpty(cities))
        .map(cities -> cities.stream().map(GetCitiesResponseMapper.INSTANCE::toGetCityResponse).collect(Collectors.toList()))
        .map(GetCitiesResponseMapper.INSTANCE::toGetCitiesResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying cities: [{}]", NOT_FOUND))
        .get();
  }
}
