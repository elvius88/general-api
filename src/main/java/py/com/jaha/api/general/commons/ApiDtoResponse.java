package py.com.jaha.api.general.commons;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import py.com.jaha.api.general.config.exception.ApiMessage;

@NoArgsConstructor
@Getter
@Setter
public class ApiDtoResponse {

  private List<ApiMessage> messages;
}
