package com.ddlab.gitpusher.github.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class GitHubRepo {

  //  private String name;
  private Repo[] repos;

  @JsonProperty("clone_url")
  private String cloneUrl;

  @JsonProperty("login")
  private String loginUser;

  //  public GitHubRepo(String name) {
  //    this.name = name;
  //  }

  public GitHubRepo() {}

  //  public String getName() {
  //    return name;
  //  }

  //  public void setName(String name) {
  //    this.name = name;
  //  }

  public Repo[] getRepos() {
    return repos;
  }

  public void setRepos(Repo[] repos) {
    this.repos = repos;
  }

  public String getLoginUser() {
    return loginUser;
  }

  public void setLoginUser(String loginUser) {
    this.loginUser = loginUser;
  }

  public String getCloneUrl() {
    return cloneUrl;
  }

  public void setCloneUrl(String cloneUrl) {
    this.cloneUrl = cloneUrl;
  }

  @Override
  public String toString() {
    return "GitHubRepo{"
        + "repos="
        + Arrays.toString(repos)
        + ", cloneUrl='"
        + cloneUrl
        + '\''
        + ", loginUser='"
        + loginUser
        + '\''
        + '}';
  }
}
