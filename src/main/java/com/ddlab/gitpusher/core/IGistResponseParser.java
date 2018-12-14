package com.ddlab.gitpusher.core;

public interface IGistResponseParser<IN, OUT> {
  OUT parse(IN in) throws Exception;
}
