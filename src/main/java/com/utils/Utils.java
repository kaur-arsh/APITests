package com.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
  public static String toJsonString(Object object) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = null;
    try {
      jsonString = mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return jsonString;
  }
}
