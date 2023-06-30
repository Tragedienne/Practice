package task3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Use_junit {
    private WebDriver driver;

    @Before
    public void Obj() {
        driver = new FirefoxDriver();
    }
    @Test
    public void Check_title() {
        driver.get("https://www.facebook.com/");
        assertEquals("Facebook - log in or sign up", driver.getTitle());
    }
    @Test
    public void Check_url() {
        driver.get("https://www.facebook.com/");
        assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
    }
    @Test
    public void Btn_click() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("test_login");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("test_pass");
        driver.findElement(By.className("login")).click();
        //assertEquals("Войдите на Facebook", driver.getTitle());
    }
    @After
    public void Close() {
        driver.close();
    }
}
