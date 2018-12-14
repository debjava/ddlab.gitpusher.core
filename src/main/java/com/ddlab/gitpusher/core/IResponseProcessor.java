package com.ddlab.gitpusher.core;

@Deprecated
public interface IResponseProcessor<T> {
    @Deprecated
    String[] processForAllRepos(T t) throws Exception;
}
