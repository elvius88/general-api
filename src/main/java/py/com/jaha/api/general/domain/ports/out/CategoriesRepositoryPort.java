package py.com.jaha.api.general.domain.ports.out;

import java.util.List;
import py.com.jaha.api.general.domain.models.categories.Category;

public interface CategoriesRepositoryPort {

  List<Category> getCategories(String name);
}
