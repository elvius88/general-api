package py.com.jaha.api.general.domain.usecases.states;

import static py.com.jaha.api.general.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.general.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.general.domain.commands.states.GetStatesCommand;
import py.com.jaha.api.general.domain.commands.states.GetStatesResponse;
import py.com.jaha.api.general.domain.ports.in.GetStatesPort;
import py.com.jaha.api.general.domain.ports.out.StatesRepositoryPort;
import py.com.jaha.api.general.domain.usecases.states.mappers.GetStatesResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetStatesUseCase implements GetStatesPort {

  private final StatesRepositoryPort statesRepositoryPort;

  @Override
  public GetStatesResponse execute(GetStatesCommand command) {
    return Try.of(() -> statesRepositoryPort.getStates(command.getName()))
        .filter(states -> !CollectionUtils.isEmpty(states))
        .map(states -> states.stream().map(GetStatesResponseMapper.INSTANCE::toGetStateResponse).collect(Collectors.toList()))
        .map(GetStatesResponseMapper.INSTANCE::toGetStatesResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying states: [{}]", NOT_FOUND))
        .get();
  }
}
