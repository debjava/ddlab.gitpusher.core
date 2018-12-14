package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

public interface IResponseParser<IN, OUT> {
  OUT getAllRepos(IN in) throws GenericGitPushException;

  OUT getUser(IN in) throws GenericGitPushException;

  OUT getNewlyCreatedHostedRepo(IN in, IErrorResponseParser<String, String> errorParser)
      throws GenericGitPushException;

  OUT getAllGistSnippets(IN in) throws GenericGitPushException;
}
