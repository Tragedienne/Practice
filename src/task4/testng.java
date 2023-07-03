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
        driver.manage().window().maximize();
    }

//    @Test
//    public void link() throws InterruptedException {
//        driver.get("https://www.hostinger.com/tutorials/how-to-make-a-website");
//        driver.findElement(By.id("email")).sendKeys("test");
//    }

    //Переход по линкам
    @Test
    public void l() throws InterruptedException {
        driver.get("https://stackoverflow.com/");
        driver.findElement(By.linkText("About")).click();
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.linkText("For Teams")).click();
        driver.navigate().back();
        Thread.sleep(5000);
    }


    @After
    public void Close() {
        driver.quit();
    }
}