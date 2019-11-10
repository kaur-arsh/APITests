package com.mensio.Login.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginFailure {
  @JsonProperty("status")
  private int status;

  @JsonProperty("message")
  private String message;
}
