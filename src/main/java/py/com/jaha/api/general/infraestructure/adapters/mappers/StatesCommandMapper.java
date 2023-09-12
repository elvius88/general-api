package py.com.jaha.api.general.infraestructure.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.commands.states.GetStatesCommand;

@Mapper
public interface StatesCommandMapper {

  StatesCommandMapper INSTANCE = Mappers.getMapper(StatesCommandMapper.class);

  default GetStatesCommand toCommand(String name) {
    return GetStatesCommand.builder().name(name).build();
  }
}
