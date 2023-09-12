package py.com.jaha.api.general.domain.usecases.cities.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.config.IdNameDto;
import py.com.jaha.api.general.domain.commands.cities.GetCitiesResponse;
import py.com.jaha.api.general.domain.models.cities.City;

@Mapper
public interface GetCitiesResponseMapper {

  GetCitiesResponseMapper INSTANCE = Mappers.getMapper(GetCitiesResponseMapper.class);

  IdNameDto<String, String> toGetCityResponse(City city);

  default GetCitiesResponse toGetCitiesResponse(List<IdNameDto<String, String>> cities) {
    return GetCitiesResponse.builder().cities(cities).build();
  }
}
