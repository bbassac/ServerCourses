package courses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by b.bassac on 23/06/2017.
 */
public class LogUtils {
    private static final Logger logger = LoggerFactory.getLogger("Server Courses");

    public static void warn(String s){
        logger.warn(s);
    }

}
