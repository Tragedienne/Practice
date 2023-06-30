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

        String expectedTitle = "Красная кнопка";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle))
        {
            System.out.println("Verification Successful.");
        }
        else
        {
            System.out.println("Verification Failed.");
        }

        WebElement Button = driver.findElement(By.className("button"));
        Button.click();

        driver.close();
        System.out.println("Test script executed successfully.");

        System.exit(0);
    }
}
