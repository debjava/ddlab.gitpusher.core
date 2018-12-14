package com.ddlab.gitpusher.core;

import java.io.File;

public interface YesGitHandler {
    void handle(File projectDir,IGitHandler gitHandler) throws Exception;
}
