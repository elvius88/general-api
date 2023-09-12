package py.com.jaha.api.general.domain.usecases.categories;

import static py.com.jaha.api.general.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.general.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesCommand;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesResponse;
import py.com.jaha.api.general.domain.ports.in.GetCategoriesPort;
import py.com.jaha.api.general.domain.ports.out.CategoriesRepositoryPort;
import py.com.jaha.api.general.domain.usecases.categories.mappers.GetCategoriesResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetCategoriesUseCase implements GetCategoriesPort {

  private final CategoriesRepositoryPort categoriesRepositoryPort;

  @Override
  public GetCategoriesResponse execute(GetCategoriesCommand command) {
    return Try.of(() -> categoriesRepositoryPort.getCategories(command.getName()))
        .filter(categories -> !CollectionUtils.isEmpty(categories))
        .map(categories -> categories.stream().map(GetCategoriesResponseMapper.INSTANCE::toGetCategoryResponse).collect(Collectors.toList()))
        .map(GetCategoriesResponseMapper.INSTANCE::toGetCategoriesResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying categories: [{}]", NOT_FOUND))
        .get();
  }
}
