package com.enums;

public enum Segmentation {
  BRANDS("brands"), //
  NETWORKS("networks") //
  ;
  private String name;

  Segmentation(String name) {
    this.name = name;
  }

  public String value() {
    return this.name;
  }

}
