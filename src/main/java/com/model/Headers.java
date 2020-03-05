package com.model;

import java.util.HashMap;
import lombok.Data;

@Data
public class Headers {
  private String url;

  HashMap<String, String> headers = new HashMap<String, String>();

  public Headers() {

    headers.put("content-type", "application/json");
    headers.put("cookie", "nomnom");

  }

  // private String headerKey1;
  // private String headerValue1;
  //
  // public void requestModal(String url, String headerKey1, String headerValue1) {
  // this.url = url;
  // this.headerKey1 = headerKey1;
  // this.headerValue1 = headerValue1;
  //
  // }
  //
  public static class builder {
    private String url;
    private HashMap<String, String> headers;
    private String headerValue;

    public builder() {}

    public builder setURL(String url) {
      this.url = url;
      return this;
    }

    // setHeader("cookie", cookie)

    public builder setHeader(String key, String value) {
      // TODO: check how to do assign value to key
      // this.header[key] = value;
      return this;
    }



  }
}
