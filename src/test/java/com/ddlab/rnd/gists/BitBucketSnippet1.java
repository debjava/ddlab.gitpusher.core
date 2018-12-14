package com.ddlab.rnd.gists;

import com.ddlab.gitpusher.core.GitResponse;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.gitpusher.util.HTTPUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;

public class BitBucketSnippet1 {
  private static String userName = "sambittechy@gmail.com";
  private static String password = "qabcd@1234";
  private static String uri = "https://api.bitbucket.org/2.0/snippets/sambittechy";
  private static File javaFile =
      new File("E:/java-dec-2018/tempParser1/src/main/java/com/ddlab/rnd/UserNameParser.java");

  public static void main(String[] args) throws Exception {
    UserAccount userAccount = new UserAccount(userName, password);
    HttpPost httppost = new HttpPost(uri);
    String encodedUser =
        HTTPUtil.getEncodedUser(userAccount.getUserName(), userAccount.getPassword());
    httppost.setHeader("Authorization", "Basic " + encodedUser);

    //      File file = new File(javaFile);
    String message = "This is a multipart post";

    //      MultipartEntity entity = new MultipartEntity();

    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      builder.addBinaryBody("file", javaFile);
      builder.addTextBody("title", "From java");
      httppost.setEntity(builder.build());

    //      builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    //      builder.addBinaryBody("upfile", javaFile, ContentType.DEFAULT_BINARY, javaFile);
    //      builder.addTextBody("text", message, ContentType.DEFAULT_BINARY);

    GitResponse gitResponse = HTTPUtil.getHttpGetOrPostResponse(httppost);

    System.out.println(gitResponse);
  }
}
