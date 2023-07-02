package task4;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testng {
    private WebDriver driver = new FirefoxDriver();

    @Before
    public void Obj() {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void link() throws InterruptedException{
        driver.findElement(By.linkText("Забыли пароль?")).click();
        driver.navigate().back();
        Thread.sleep(5000);
    }

//    @AfterSuite
//    public static void Message() {
//        System.out.println("Testing is completed.");
//    }
//
    @After
    public void Close() {
        driver.quit();
    }
}