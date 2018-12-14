package com.ddlab.gitpusher.github.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeFiles {

  @JsonProperty("content")
  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
