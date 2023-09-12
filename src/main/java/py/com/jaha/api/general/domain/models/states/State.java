package py.com.jaha.api.general.domain.models.states;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import py.com.jaha.api.general.config.IdNameDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class State extends IdNameDto<String, String> implements Serializable {
}
