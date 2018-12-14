package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

import java.io.File;

public interface IGitPusher {
  void pushCodeDirectly(File projectDir) throws GenericGitPushException;
}
