package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
* This class models the context menu page that is tested in the { @CookiesTests } test class (src/test/cookies). 
*/
public class CookieManager {

    private WebDriver driver;

    public CookieManager (WebDriver driver){
        this.driver = driver;
    }

    // Cookies use the Builder pattern to help create cookies more effitiently. 
    public Cookie buildCookie(String cookieName, String cookieValue){
        Cookie cookie = new Cookie.Builder(cookieName, cookieValue)
                .domain("the-internet.herokuapp.com")
                .build();
        return cookie;
    }

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }

    public void setCookie (String cookieName, String cookieValue){
        Cookie cookie = new Cookie.Builder(cookieName, cookieValue)
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    public boolean readCookie (String cookieName){
        var cookies = driver.manage().getCookies();
        for (var cookie : cookies){
            if (cookie.getName().equals(cookieName)){
                return false;
            }
        }
        return true;
    }

}
