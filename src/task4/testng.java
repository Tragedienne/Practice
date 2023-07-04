package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testng {
    private WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    public void Obj() {
        driver.get("https://stackoverflow.com/");
        driver.manage().window().maximize();
        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.findElement(By.partialLinkText("Teams")).click();
        driver.navigate().back();
        Thread.sleep(5000);
    }

    //Проверка видимости элемента
    @Test(priority = 3)
    public void visibility() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/header/div/nav/ol/li[4]/a")).click();
        boolean is_displayed = driver.findElement(By.id("submit-button")).isDisplayed();
        System.out.println(is_displayed);

        boolean is_displayed_check = driver.findElement(By.id("submit-button")).isDisplayed();
        boolean is_enabled = driver.findElement(By.id("opt-in")).isEnabled();
        if (is_displayed_check == true && is_enabled == true) {
            driver.findElement(By.id("opt-in")).click();
            System.out.println(is_enabled);
        }
        driver.navigate().back();
        Thread.sleep(5000);
    }

    //Ожидание (явное)
    @Test(priority = 4)
    public void waiting() {
        driver.findElement(By.xpath("/html/body/header/div/nav/ol/li[3]/a")).click();
        driver.findElement(By.id("email")).sendKeys("sanya.gubanova.02@gmail.com");
        driver.findElement(By.id("password")).sendKeys("alya2002");
        driver.findElement(By.id("submit-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div/a")));
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div/a")).click();

        driver.navigate().back();
    }

    //Пример обработки всплывающего окна (на другом сайте)
    @Test(priority = 5)
    public void alerts() throws InterruptedException {
        driver.get("https://learn.javascript.ru/uibasic");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/main/div[1]/article/div[2]/div[8]/div/div[1]/div[1]/a")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.navigate().back();
    }

    @Test(priority = 6)
    public void exceptions(){
        driver.findElement(By.xpath("/html/body/header/div/nav/ol/li[3]/a")).click();
        driver.findElement(By.id("email")).sendKeys("sanya.gubanova.02@gmail.com");
        driver.findElement(By.id("password")).sendKeys("alya2002");
        WebElement submitBtn = driver.findElement(By.id("submit-button"));
        try{
            if(submitBtn.isDisplayed()){
                submitBtn.click();
            }
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void Close() {
        driver.quit();
    }
}