package py.com.jaha.api.general.domain.models.cities;

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
public class City extends IdNameDto<String, String> implements Serializable {
}
