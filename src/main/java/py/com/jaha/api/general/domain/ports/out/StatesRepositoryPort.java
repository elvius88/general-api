package py.com.jaha.api.general.domain.ports.out;

import java.util.List;
import py.com.jaha.api.general.domain.models.states.State;

public interface StatesRepositoryPort {

  List<State> getStates(String name);
}
