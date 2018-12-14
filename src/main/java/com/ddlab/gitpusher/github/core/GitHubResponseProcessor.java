package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IResponseProcessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class GitHubResponseProcessor implements IResponseProcessor<String> {

  private ObjectMapper mapper = null;

  public GitHubResponseProcessor() {
    this.mapper = new ObjectMapper();
  }

  @Override
  public String[] processForAllRepos(String jsonResponse) throws Exception {
    List<String> reposList = new ArrayList<>();
    try {
      JsonNode node = mapper.readTree(jsonResponse);
      if (node.isArray()) {
        for (final JsonNode objNode : node) {
          reposList.add(objNode.get("name").asText());
        }
      }
    } catch (IOException e) {
      throw e;
    }
    return reposList.toArray(new String[0]);
  }
}
