package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.categories.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.models.categories.Category;
import py.com.jaha.api.general.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.categories.entities.Categories;

@Mapper
public interface CategoriesMapper extends IMapper<Category, Categories> {

  CategoriesMapper INSTANCE = Mappers.getMapper(CategoriesMapper.class);
}
