package com.ddlab.gitpusher.github.bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder({"description", "public", "files"})
public class CodeSnippet {
  @JsonProperty("description")
  private String description;

  @JsonProperty("public")
  private boolean isPublic = true;

  @JsonProperty("files")
  private Map<String, CodeFiles> files;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean isPublic) {
    this.isPublic = isPublic;
  }

  public Map<String, CodeFiles> getFiles() {
    return files;
  }

  public void setFiles(Map<String, CodeFiles> files) {
    this.files = files;
  }

  public String toJSON() {
    ObjectMapper mapper = new ObjectMapper();
    String toJson = null;
    try {
      toJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return toJson;
  }

  public static void main(String[] args) {
    CodeSnippet snippet = new CodeSnippet();
//    snippet.setPublic(true);
    snippet.setDescription("it is only for testing.");

    CodeFiles codeFile = new CodeFiles();
    //    codeFile.setFileName("test.java");
    codeFile.setContent("System.out.println");
    Map<String, CodeFiles> codeMap = new HashMap<>();
    codeMap.put("test.java", codeFile);

    snippet.setFiles(codeMap);

    System.out.println(snippet.toJSON());
  }
}
