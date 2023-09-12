package py.com.jaha.api.general.domain.models.categories;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

  private String id;
  private String name;
  private String imageAppPath;
  private String imageWebPath;
}
