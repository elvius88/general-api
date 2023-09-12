package py.com.jaha.api.general.domain.commands.categories;

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
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse implements Serializable {

  private String id;
  private String name;
  private String imageAppPath;
  private String imageWebPath;
}
