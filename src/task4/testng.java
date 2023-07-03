package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testng {
    private WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    public void Obj() {
        driver.manage().window().maximize();
    }

    //Проверка актуального заголовка сайта
    @Test(priority = 1)
    public void title() {
        driver.get("https://stackoverflow.com/");
        Assert.assertEquals("Stack Overflow - Where Developers Learn, Share, & Build Careers", driver.getTitle());
    }

    //Переход по линкам
    @Test(priority = 2)
    public void link() throws InterruptedException {
        driver.get("https://stackoverflow.com/");
        driver.findElement(By.linkText("About")).click();
        driver.navigate().back();
        driver.findElement(By.linkText("For Teams")).click();
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @AfterSuite
    public void Close() {
        driver.quit();
    }
}