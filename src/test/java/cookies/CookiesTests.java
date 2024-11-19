package cookies;

import base.BaseTestsTAU;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
* This test class is an example of how we can add, read or remove cookies to process data. 
* Cookies use the Builder pattern to help create cookies more effitiently. 
* It related to { @CookieManager } class. 
*/ 
public class CookiesTests extends BaseTestsTAU {

    /**
    * Process:
    * <ol>
    *   <li>Cookie name and value are defined in the test.</li>
    *   <li>Variables are passed to the buildCookie() method and the cookie is stored.</li>
    *   <li>A breakpoint can be added here to ensure that the cookie is stored properly before deleting it.</li>
    *   <li>The cookie manager deletes the cookie again and it is validated that the cookie is deleted properly.</li>
    * </ol>    
    * 
    * The getCookieManage can be found in the { @baseTestsTAU } configuration class.
    */
    @Test
    public void testDeleteCookie(){
        String cookieName = "optimizelyBuckets";
        String cookieValue = "%7B%7D";
        var cookie = getCookieManager().buildCookie(cookieName, cookieValue);
        getCookieManager().deleteCookie(cookie);
        assertTrue(getCookieManager().readCookie(cookie.getName()), "The cookie wasn't deleted.");
    }

}
