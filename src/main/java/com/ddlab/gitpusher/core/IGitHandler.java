package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.github.bean.GitHubRepo;

import java.io.File;

public interface IGitHandler {
  String getUserName() throws Exception;

  String[] getAllRepositories() throws Exception;

  boolean repoExists(String repoName) throws Exception;

  String getUrlFromLocalRepsitory(File gitDirPath) throws Exception;

  boolean isGitDirAvailable(File gitDirPath) throws Exception;

  void createHostedRepo(String repoName) throws Exception;

  void clone(String repoName, File dirPath) throws Exception;

  void update(File cloneDirPath, String message) throws Exception;

  String[] getGists() throws Exception;

  void createGist(File file, String description) throws Exception;
}
