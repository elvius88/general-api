package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.cities;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.cities.entities.Cities;

@Repository
public interface CitiesRepository extends CrudRepository<Cities, String> {

  @Query("SELECT c FROM Cities c " +
      "WHERE (:name IS NULL OR c.name LIKE %:name%) " +
      "AND (:state IS NULL OR c.stateId = :state) " +
      "ORDER BY c.name")
  List<Cities> findCitiesBy(@Param("name") String name,
                            @Param("state") String state);
}

