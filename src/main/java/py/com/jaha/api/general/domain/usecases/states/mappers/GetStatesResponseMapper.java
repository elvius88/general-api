package py.com.jaha.api.general.domain.usecases.states.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.config.IdNameDto;
import py.com.jaha.api.general.domain.commands.states.GetStatesResponse;
import py.com.jaha.api.general.domain.models.states.State;

@Mapper
public interface GetStatesResponseMapper {

  GetStatesResponseMapper INSTANCE = Mappers.getMapper(GetStatesResponseMapper.class);

  IdNameDto<String, String> toGetStateResponse(State state);

  default GetStatesResponse toGetStatesResponse(List<IdNameDto<String, String>> states) {
    return GetStatesResponse.builder().states(states).build();
  }
}
