package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class testng {
    private WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    public void Obj() {
        driver.get("https://stackoverflow.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Проверка актуального заголовка сайта
    @Test(priority = 1)
    public void title() {
        Assert.assertEquals("Stack Overflow - Where Developers Learn, Share, & Build Careers", driver.getTitle());
    }

    //Переход по линкам
    @Test(priority = 2)
    public void link() throws InterruptedException {
        driver.findElement(By.linkText("About")).click();
        driver.navigate().back();
        driver.findElement(By.linkText("For Teams")).click();
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void visibility() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/header/div/nav/ol/li[4]/a")).click();
        boolean is_displayed = driver.findElement(By.id("submit-button")).isDisplayed();
        System.out.println(is_displayed);
        //Проверка на присутствие элемента, а так же включен/отключен он
        boolean is_displayed_check = driver.findElement(By.id("submit-button")).isDisplayed();
        boolean is_enabled = driver.findElement(By.id("opt-in")).isEnabled();
        if (is_displayed_check == true && is_enabled == true) {
            driver.findElement(By.id("opt-in")).click();
            System.out.println(is_enabled);
        }
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @AfterSuite
    public void Close() {
        driver.quit();
    }
}