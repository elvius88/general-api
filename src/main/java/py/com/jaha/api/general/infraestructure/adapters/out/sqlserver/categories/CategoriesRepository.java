package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.categories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.categories.entities.Categories;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, String> {


  @Query("SELECT c FROM Categories c " +
      "WHERE (:name IS NULL OR c.name LIKE %:name%) " +
      "ORDER BY c.name")
  List<Categories> findCategoriesBy(@Param("name") String name);
}

