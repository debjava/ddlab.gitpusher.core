package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IErrorResponseParser;
import com.ddlab.gitpusher.exception.GenericGitPushException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

public class RepoCreateErrorResponseParser implements IErrorResponseParser<String, String> {
  @Override
  public String parseError(String jsonText) throws GenericGitPushException {
    String errorMessage = null;
    try {
      errorMessage = getErrorMessage(jsonText);
    } catch (IOException e) {
      throw new GenericGitPushException(
          "Unable to parse error message coming out of Repo creation in GitHub.");
    }
    return errorMessage;
  }

  private String getErrorMessage(String jsonText) throws IOException {
    StringBuilder builder = new StringBuilder("");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(jsonText);
    JsonNode errorNode = root.get("errors");
    if (errorNode.isArray()) {
      Iterator<JsonNode> itr = errorNode.iterator();
      while (itr.hasNext()) {
        JsonNode tempNode = itr.next();
        JsonNode msgNode = tempNode.get("message");
        if (msgNode != null) builder.append(msgNode.asText()).append("\n");
      }
    }
    return builder.toString();
  }
}
