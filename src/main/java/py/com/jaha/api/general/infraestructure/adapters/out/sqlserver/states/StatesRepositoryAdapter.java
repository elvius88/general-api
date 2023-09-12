package py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.states;

import io.vavr.control.Try;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import py.com.jaha.api.general.domain.models.states.State;
import py.com.jaha.api.general.domain.ports.out.StatesRepositoryPort;
import py.com.jaha.api.general.infraestructure.adapters.out.sqlserver.states.mapper.StatesMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatesRepositoryAdapter implements StatesRepositoryPort {

  private final StatesRepository statesRepository;

  @Override
  public List<State> getStates(String name) {
    return Try.of(() -> statesRepository.findStatesBy(name))
        .map(StatesMapper.INSTANCE::toDomainList)
        .get();
  }
}
