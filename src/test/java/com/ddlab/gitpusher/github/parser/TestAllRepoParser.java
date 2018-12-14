package com.ddlab.gitpusher.github.parser;

import com.ddlab.gitpusher.core.IResponseParser;
import com.ddlab.gitpusher.github.bean.GitHubRepo;
import com.ddlab.gitpusher.github.bean.Repo;
import com.ddlab.gitpusher.github.core.GitHubResponseParserImpl;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestAllRepoParser {
  public static void main(String[] args) throws Exception {
    IResponseParser<String, GitHubRepo> responseParser = new GitHubResponseParserImpl();
    String jsonResponse =
        new String(Files.readAllBytes(Paths.get("E:/java-dec-2018/tempJgit1/testdata/a.json")));
//    System.out.println(jsonResponse);
    GitHubRepo gitRepo = responseParser.getAllRepos(jsonResponse);
    Repo[] repos = gitRepo.getRepos();
    for (Repo repo : repos) {
      System.out.println(repo);
    }
  }
}
