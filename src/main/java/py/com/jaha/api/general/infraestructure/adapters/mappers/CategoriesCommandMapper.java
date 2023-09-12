package py.com.jaha.api.general.infraestructure.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesCommand;

@Mapper
public interface CategoriesCommandMapper {

  CategoriesCommandMapper INSTANCE = Mappers.getMapper(CategoriesCommandMapper.class);

  default GetCategoriesCommand toCommand(String name) {
    return GetCategoriesCommand.builder().name(name).build();
  }
}
