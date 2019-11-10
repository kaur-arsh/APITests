package com.mensio.Login.response;

import com.enums.LoginType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRecord {
  @JsonProperty("type")
  private LoginType loginType;
}
