package com.ddlab.gitpusher.core;

public class GitResponse {
  private String statusCode;
  private String responseText;

  public GitResponse(String statusCode, String responseText) {
    this.statusCode = statusCode;
    this.responseText = responseText;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public String getResponseText() {
    return responseText;
  }

  @Override
  public String toString() {
    return "GitResponse{"
        + "statusCode='"
        + statusCode
        + '\''
        + ", responseText='"
        + responseText
        + '\''
        + '}';
  }
}
