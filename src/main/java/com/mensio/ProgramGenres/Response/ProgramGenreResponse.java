package com.mensio.ProgramGenres.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mensio.Audiences.response.AudienceData;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramGenreResponse {

    @JsonProperty("options") List<AudienceData> audiences;

    }
