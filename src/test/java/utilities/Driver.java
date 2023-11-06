package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
    private static WebDriver driver;

    public static WebDriver setUp(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void tearDown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }

    }

}
