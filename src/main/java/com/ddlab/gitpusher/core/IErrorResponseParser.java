package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

public interface IErrorResponseParser<IN, OUT> {
  OUT parseError(IN in) throws GenericGitPushException;
}
