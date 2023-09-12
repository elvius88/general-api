package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.cities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.models.cities.City;
import py.com.jaha.api.general.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.cities.entities.Cities;

@Mapper
public interface CitiesMapper extends IMapper<City, Cities> {

  CitiesMapper INSTANCE = Mappers.getMapper(CitiesMapper.class);
}
