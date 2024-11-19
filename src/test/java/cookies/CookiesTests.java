package cookies;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CookiesTests extends BaseTestsTAU {

    @Test
    public void testDeleteCookie(){
        String cookieName = "optimizelyBuckets";
        String cookieValue = "%7B%7D";
        var cookie = getCookieManager().buildCookie(cookieName, cookieValue);
        getCookieManager().deleteCookie(cookie);
        assertTrue(getCookieManager().readCookie(cookie.getName()), "The cookie wasn't deleted.");
    }

}
