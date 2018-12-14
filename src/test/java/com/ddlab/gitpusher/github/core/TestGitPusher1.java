package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.UserAccount;

import java.io.File;

public class TestGitPusher1 {
  private static String userName = "sambittechy@gmail.com";
  private static String password = "abcd@1234";
//  private static File projectDir = new File("E:/sure-delete-1/dummy1");
//private static File projectDir = new File("E:/sure-delete-1/deleteMe1");
private static File projectDir = new File("E:/sure-delete-1/temp1");

  public static void main(String[] args) {
    UserAccount userAccount = new UserAccount(userName, password);
    IGitHandler gitHubHandler = new GitHubHandlerImpl(userAccount);
    IGitPusher pusher = new GitHubPusherImpl(gitHubHandler);
    try {
      pusher.pushCodeDirectly(projectDir);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
