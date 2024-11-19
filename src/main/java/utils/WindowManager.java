package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigation;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigation = driver.navigate();

    }

    public void goBack(){
        navigation.back();
    }

    public void goForward(){
        navigation.forward();
    }

    public void refreshPage(){
        navigation.refresh();
    }

    public void goTo (String url){
        navigation.to(url);
    }

    // Multiple tabs in the browser.

    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();
        System.out.println("Number of windows: "+windows.size());

        System.out.println("Windows handles: ");
        windows.forEach(System.out::println);

        for (var window : windows){
            driver.switchTo().window(window);

            if (tabTitle.equals(driver.getTitle())){
                System.out.println("The tab title you asked for is: "+driver.getTitle());
                break;
            }
        }
    }

}
