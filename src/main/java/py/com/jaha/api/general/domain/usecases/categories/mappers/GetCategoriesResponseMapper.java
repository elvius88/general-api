package py.com.jaha.api.general.domain.usecases.categories.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesResponse;
import py.com.jaha.api.general.domain.commands.categories.GetCategoryResponse;
import py.com.jaha.api.general.domain.models.categories.Category;

@Mapper
public interface GetCategoriesResponseMapper {

  GetCategoriesResponseMapper INSTANCE = Mappers.getMapper(GetCategoriesResponseMapper.class);

  GetCategoryResponse toGetCategoryResponse(Category category);

  default GetCategoriesResponse toGetCategoriesResponse(List<GetCategoryResponse> categories) {
    return GetCategoriesResponse.builder().categories(categories).build();
  };
}
