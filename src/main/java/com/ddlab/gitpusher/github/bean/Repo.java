package com.ddlab.gitpusher.github.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Repo {
  @JsonProperty("name")
  private String name;

  @JsonProperty("clone_url")
  private String cloneUrl;

  public Repo(String name, String cloneUrl) {
    this.name = name;
    this.cloneUrl = cloneUrl;
  }

  public Repo() {}

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setCloneUrl(String cloneUrl) {
    this.cloneUrl = cloneUrl;
  }

  public String getCloneUrl() {
    return cloneUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Repo repo = (Repo) o;
    return Objects.equals(name, repo.name) && Objects.equals(cloneUrl, repo.cloneUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cloneUrl);
  }

  @Override
  public String toString() {
    return "Repo{" + "name='" + name + '\'' + ", cloneUrl='" + cloneUrl + '\'' + '}';
  }
}
