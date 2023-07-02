package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Btn_click {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://games.logicplays.com/red-button/");

        driver.manage().window().maximize();

        WebElement Button = driver.findElement(By.className("button"));
        Button.click();

        driver.close();
        System.out.println("Test script executed successfully.");

        System.exit(0);
    }
}
