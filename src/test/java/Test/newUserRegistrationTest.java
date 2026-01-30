package Test;

import Pages.HomePage;
import Pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class newUserRegistrationTest {
    @Test
    public void new_User_Registration(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try{
            driver.get("https://www.demoblaze.com/");
            driver.manage().window().maximize();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin2")));
            HomePage homePage = new HomePage(driver);
            homePage.clickSignUp();
            SignUpPage signUpPage = new SignUpPage(driver);
            signUpPage.doSignUp("testNew@gmail.com", "P@ssw0rd123");
        }finally {
            driver.quit();
        }

    }
}
