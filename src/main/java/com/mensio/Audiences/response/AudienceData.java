package com.mensio.Audiences.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudienceData {
  @JsonProperty("active")
  private String AudienceStatus;

  @JsonProperty("display_name")
  private String AudienceName;
}
