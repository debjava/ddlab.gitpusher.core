package com.ddlab.gitpusher.exception;

public class GenericGitPushException extends Exception {
  private String errMessage;

  public GenericGitPushException(String errMessage) {
    super(errMessage);
  }

  public GenericGitPushException(String message, Throwable cause) {
    super(message, cause);
    this.errMessage = message;
  }
}
