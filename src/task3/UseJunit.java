package task3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UseJunit {
    private WebDriver driver;

    @Before
    public void Obj() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void Check_title() {
        assertEquals("Facebook - log in or sign up", driver.getTitle());
    }

    @Test
    public void Check_url() {
        assertTrue("Url is incorrect.", "https://www.facebook.com/".equals(driver.getCurrentUrl()));
    }

    @Test
    public void Login() {
        driver.findElement(By.id("email")).sendKeys("test_login");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("test_pass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Test
    public void Createpage() {
        driver.findElement(By.className("_8esh")).click();
        assertEquals("Facebook", driver.getTitle());
    }

    @After
    public void Close() {
        driver.close();
    }
}
