package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin2")));
        driver.findElement(By.id("signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='signInModalLabel']")));
        driver.findElement(By.id("sign-username")).sendKeys("sagarg@gmail.com");
        driver.findElement(By.id("sign-password")).sendKeys("P@ssw0rd@123");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText = "Sign up successful.";
        //System.out.println(actualAlertText);

        if (actualAlertText.equals(expectedAlertText)){
            System.out.println(expectedAlertText);
        }else {
            System.out.println(actualAlertText);
        }

        driver.quit();

    }
}
