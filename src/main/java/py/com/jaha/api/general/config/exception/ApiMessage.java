package py.com.jaha.api.general.config.exception;

import py.com.jaha.api.general.config.DtoMeta;

@DtoMeta
public class ApiMessage {
  private String code;
  private String message;
  private String userMessage;
  private ApiMessageTypes type;
  private Boolean useApiMessage;

  public ApiMessage(String code, String message, ApiMessageTypes type) {
    this.code = code;
    this.message = message;
    this.type = type;
    this.userMessage = message;
    this.useApiMessage = false;
  }

  public ApiMessage(final String code, final String message, final String userMessage, final ApiMessageTypes type, final Boolean useApiMessage) {
    this.code = code;
    this.message = message;
    this.userMessage = userMessage;
    this.type = type;
    this.useApiMessage = useApiMessage;
  }

  public ApiMessage() {
  }

  public String toString() {
    String var10000 = this.getCode();
    return "ApiMessage(code=" + var10000 + ", message=" + this.getMessage() + ", userMessage=" + this.getUserMessage() + ", type=" + this.getType() + ", useApiMessage=" + this.getUseApiMessage() + ")";
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public String getUserMessage() {
    return this.userMessage;
  }

  public ApiMessageTypes getType() {
    return this.type;
  }

  public Boolean getUseApiMessage() {
    return this.useApiMessage;
  }

  public void setCode(final String code) {
    this.code = code;

  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public void setUserMessage(final String userMessage) {
    this.userMessage = userMessage;
  }

  public void setType(final ApiMessageTypes type) {
    this.type = type;
  }

  public void setUseApiMessage(final Boolean useApiMessage) {
    this.useApiMessage = useApiMessage;
  }
}
