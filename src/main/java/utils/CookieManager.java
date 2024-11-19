package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {

    private WebDriver driver;

    public CookieManager (WebDriver driver){
        this.driver = driver;
    }

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
