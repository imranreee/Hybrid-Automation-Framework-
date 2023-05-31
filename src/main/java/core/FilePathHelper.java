package core;

import java.io.File;

public class FilePathHelper {
    public static final String dir = System.getProperty("user.dir");
    static File f = new File(dir);
    static String filepath = f.getParent();
    public static final String JSonFilePath = filepath+"/Selenium_Basic_2/src/main/java/repository/local_repo";
    public static final String employeeRgePostJSonFIlePath = JSonFilePath +"/employee_reg_post.json";
    public static final String POST_LOGIN_JSON_FILE_PATH = JSonFilePath +"/api_post_login.json";
    public static final String regPostJsonFilePath = JSonFilePath +"/reg_post.json";
}
