package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.UserAccount;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

public class Test1 {
  private static String userName = "sambittechy@gmail.com";
  private static String password = "abcd@1234";

  public static Duration getDifference(Instant start) {
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    return timeElapsed;
  }

  public static void cloneRepo(String repoName, File dirPath) throws Exception {
    Instant start = Instant.now();
    UserAccount userAccount = new UserAccount(userName, password);
    IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
    gitHandler.clone(repoName, dirPath);

    System.out.println("Time taken: " + getDifference(start).toMillis() + " milliseconds");
    System.out.println("Time taken: " + getDifference(start).toMillis() / 1000 + " seconds");
  }

  public static void main(String[] args) throws Exception {

    //    UserAccount userAccount = new UserAccount(userName, password);
    //    IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
    //    Instant start = Instant.now();
    //    String loginUser = gitHandler.getUserName();
    //    System.out.println("GitHub Login User : " + loginUser);
    //
    //    GitHubRepo gitRepo = gitHandler.getAllRepositories();
    //    Repo[] repos = gitRepo.getRepos();
    //    for (Repo repo : repos) {
    //      System.out.println(repo.getName() + "-----" + repo.getCloneUrl());
    //    }
    //    String existVal = gitHandler.repoExists("Doma-Doma1") ? "Repo exists..." : "Does not
    // exist";
    //    System.out.println(existVal);
    //    System.out.println("Time taken: " + getDifference(start).toMillis() + " milliseconds");
    //    System.out.println("Time taken: " + getDifference(start).toMillis() / 1000 + " seconds");

//    String repoName = "deleteMe1";
    String repoName = "spring-security-oauth";
    File dirPath = new File("E:/sure-delete-1"+File.separator+repoName);

    cloneRepo(repoName, dirPath);
  }
}
