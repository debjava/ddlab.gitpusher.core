package com.ddlab.gitpusher.core;

import java.io.File;

public interface NoGitHandler {
  void handle(File projectDir, IGitHandler gitHandler) throws Exception;
}
