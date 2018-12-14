package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.NoGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import com.ddlab.gitpusher.exception.GenericGitPushException;

import java.io.File;

public class GitHubPusherImpl implements IGitPusher {
  private IGitHandler gitHubHandler;
  private NoGitHandler noGitHandler;
  private YesGitHandler yesGitHandler;

  public GitHubPusherImpl(IGitHandler gitHubHandler) {
    this.gitHubHandler = gitHubHandler;
    noGitHandler = new NoGitHubHandlerImpl();
    yesGitHandler = new YesGitHubHandlerImpl();
  }

  @Override
  public void pushCodeDirectly(File projectDir) throws GenericGitPushException {
    String repoName = projectDir.getName();
    File tempCloneDir = null;
    try {
      boolean isGitAvailable = gitHubHandler.isGitDirAvailable(projectDir);
      if (isGitAvailable) {
        // Handle it differently
        // YesGitHanlder
        yesGitHandler.handle(projectDir, gitHubHandler);
      } else {
        // No git Handler
        noGitHandler.handle(projectDir, gitHubHandler);
      }
    } catch (Exception e) {
      throw new GenericGitPushException("Exception while pushing code to GIT", e);
    }
  }
}
