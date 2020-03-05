package com.mensio.Audiences.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudienceResponse {

  @JsonProperty("options")
  List<AudienceData> audiences;

}
