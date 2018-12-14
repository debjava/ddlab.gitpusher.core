package com.ddlab.gitpusher.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    //Product Specific
    public static final String HOME_DIR = System.getProperty("user.home");
    public static final String TEMP_GIT_PATH = "DDLAB";
    public static final String HOME_GIT_PATH = CommonUtil.getTempGitLocation();
    public static final String DATE_PATTERN = "dd-MMM-yyyy hh:mm a";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);

    public static String getTempGitLocation() {
        File tempGitDir = new File(HOME_DIR + File.separator + TEMP_GIT_PATH);
        if (!tempGitDir.exists()) tempGitDir.mkdirs();
        return tempGitDir.getAbsolutePath();
    }

    public static final String getTodayDateTime() {
        return DATE_FORMAT.format(new Date());
    }


}
