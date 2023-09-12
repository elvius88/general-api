package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.categories;

import io.vavr.control.Try;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;
import py.com.jaha.api.general.domain.models.categories.Category;
import py.com.jaha.api.general.domain.ports.out.CategoriesRepositoryPort;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.categories.mapper.CategoriesMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoriesRepositoryAdapter implements CategoriesRepositoryPort {

  private final CategoriesRepository categoriesRepository;

  @Override
  public List<Category> getCategories(String name) {
    return Try.of(() -> categoriesRepository.findCategoriesBy(name))
        .map(CategoriesMapper.INSTANCE::toDomainList)
        .get();
  }
}
