package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testng {
    public WebDriver driver = new FirefoxDriver();

    @Test
    public void gmailLogin() {
        // launch the firefox browser and open the application url
        driver.get("https://ru-ru.facebook.com/");

        driver.manage().window().maximize();

// fetch the title of the web page and save it into a string variable
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals("Facebook - log in or sign up",actualTitle);

        WebElement username = driver.findElement(By.id("email"));
        username.clear();
        username.sendKeys("test");

        WebElement password = driver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("test");

        WebElement SignInButton = driver.findElement(By.name("login"));
        SignInButton.click();

        driver.close();
    }
}