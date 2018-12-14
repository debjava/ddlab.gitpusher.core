package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;

import java.io.File;

public class YesGitHubHandlerImpl implements YesGitHandler {

  @Override
  public void handle(File projectDir, IGitHandler gitHandler) throws Exception {
    Git git = Git.open(projectDir);
    Repository repository = git.getRepository();
    String url = repository.getConfig().getString("remote", "origin", "url");
    gitHandler.update(projectDir, null);

//    if (url != null && url.indexOf("github.com") != -1) {
//      System.out.println("Same as selected - like github");
//      // Simply update and push the code to github
//      gitHandler.update(projectDir, null);
//      System.out.println("All the files have been updated and pushed to GitHub successfully");
//    } else {
//      // Do it differently
//    }




  }
}
