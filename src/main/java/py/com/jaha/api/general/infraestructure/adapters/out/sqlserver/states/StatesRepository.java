package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.states;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.states.entities.States;

@Repository
public interface StatesRepository extends CrudRepository<States, String> {

  @Query("SELECT s FROM States s " +
      "WHERE (:name IS NULL OR s.name LIKE %:name%) " +
      "ORDER BY s.name")
  List<States> findStatesBy(@Param("name") String name);
}

