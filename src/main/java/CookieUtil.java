import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    public static String getCookie(String key, HttpServletRequest req) {
        return getCookies(req).get(key);
    }

    public static void addCookie(String cookieKey, String cookieValue, HttpServletResponse resp) {
        resp.addCookie( new Cookie(cookieKey, cookieValue));
    }

    public static Map<String, String> getCookies(HttpServletRequest req) {
        Map<String, String> cookies = new HashMap<>();

        String cookie = req.getHeader("Cookie");
        if (cookie != null) {
            for (String pair : cookie.split(";")) {
                String[] new_pair = pair.split("=");
                cookies.put(new_pair[0], new_pair[1]);
            }
        }


        return cookies;
    }
}
