package com.mensio.Brands.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandData {

  @JsonProperty("id")
  private String brandId;

  @JsonProperty("display_name")
  private String brandName;
}
