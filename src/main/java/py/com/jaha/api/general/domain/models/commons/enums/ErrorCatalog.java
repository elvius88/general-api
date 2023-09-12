package py.com.jaha.api.general.domain.models.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCatalog {
  GLOBAL_GENERAL_DATABASE_ERROR_CODE("GEN0001", "Error de conexión con la base de datos", null),
  GLOBAL_VALIDATION_ERROR_CODE("GEN0002", "Datos de búsqueda incorrectos", null),
  NOT_FOUND("GEN0003", "Datos no encontrados", null),
  ERROR_GETTING_EXTERNAL_CODE("GEN0004", "Error de BanTotal no configurado", null),
  INVALID_JSON_DATA_SERIALIZE("GEN0005", "Ocurrió un error al serializar la información", null),
  INVALID_JSON_DATA_PARAM("GEN0006", "Ocurrió un error al deserializar la información", null);

  private final String code;
  private final String description;
  // Only for errors obtained from external apis
  private final Long externalCode;
}
