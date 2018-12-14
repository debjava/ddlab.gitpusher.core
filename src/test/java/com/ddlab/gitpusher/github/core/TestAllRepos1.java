package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.gitpusher.github.bean.GitHubRepo;
import com.ddlab.gitpusher.github.bean.Repo;

public class TestAllRepos1 {
  private static String userName = "sambittechy@gmail.com";
  private static String password = "abcd@1234";

  public static void main(String[] args) throws Exception {
    UserAccount userAccount = new UserAccount(userName, password);
    IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
    String[] repos = gitHandler.getAllRepositories();
    for(String repo : repos)
        System.out.println(repo);
//    GitHubRepo gitRepo = gitHandler.getAllRepositories();
//    Repo[] repos = gitRepo.getRepos();
//    for (Repo repo : repos) {
//      System.out.println(repo.getName() + "-----" + repo.getCloneUrl());
//    }
  }
}
