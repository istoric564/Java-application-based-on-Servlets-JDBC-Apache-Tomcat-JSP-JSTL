package http.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {

    private static final String JSP_FORMAT = "/WEB-INF/jsp/content.jsp";

    public static String getPath(String jspName){
        return String.format(JSP_FORMAT, jspName);
    }
}
