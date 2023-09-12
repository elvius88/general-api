package py.com.jaha.api.general.infraestructure.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.commands.cities.GetCitiesCommand;

@Mapper
public interface CitiesCommandMapper {

  CitiesCommandMapper INSTANCE = Mappers.getMapper(CitiesCommandMapper.class);

  default GetCitiesCommand toCommand(String name, String state) {
    return GetCitiesCommand.builder().name(name).state(state).build();
  }
}
