package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginInfo {
  @JsonProperty("cookie")
  @Getter
  @Setter
  private static String cookie;
}
