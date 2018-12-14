package com.ddlab.gitpusher.bitbucket.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.NoGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import com.ddlab.gitpusher.exception.GenericGitPushException;
import com.ddlab.gitpusher.github.core.NoGitHubHandlerImpl;
import com.ddlab.gitpusher.github.core.YesGitHubHandlerImpl;

import java.io.File;

public class BitBucketPusherImpl implements IGitPusher {
  private IGitHandler gitHubHandler;
  private NoGitHandler noGitHandler;
  private YesGitHandler yesGitHandler;

  public BitBucketPusherImpl(IGitHandler gitHubHandler) {
    this.gitHubHandler = gitHubHandler;
    noGitHandler = new NoBitBucketGitHandler();
    yesGitHandler = new YesBitBucketGitHandler();
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
