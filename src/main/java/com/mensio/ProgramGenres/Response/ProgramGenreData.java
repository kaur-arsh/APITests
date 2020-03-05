package com.mensio.ProgramGenres.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class ProgramGenreData {
        @JsonProperty("active")
        private String ProgramGenreStatus;

        @JsonProperty("display_name")
        private String ProgramGenreName;
    }

