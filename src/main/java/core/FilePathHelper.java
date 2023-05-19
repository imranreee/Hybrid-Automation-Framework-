package core;

import java.io.File;

public class FilePathHelper {
    public static final String dir = System.getProperty("user.dir");
    static File f = new File(dir);
    static String filepath = f.getParent();
    public static final String FileBathInCore = filepath+"/Selenium_Basic_2/src/main/java/repository/local_repo";
    public static final String employeeRgePostAPIPath = FileBathInCore+"/employee_reg_post.json";
}
