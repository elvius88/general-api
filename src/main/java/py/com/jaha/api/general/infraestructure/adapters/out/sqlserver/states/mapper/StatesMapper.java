package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.states.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.models.states.State;
import py.com.jaha.api.general.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.states.entities.States;

@Mapper
public interface StatesMapper extends IMapper<State, States> {

  StatesMapper INSTANCE = Mappers.getMapper(StatesMapper.class);
}
