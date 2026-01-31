import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AddToCartValidationTests {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        driver.findElement(By.id("loginusername")).sendKeys("sagarg@gmail.com");
        driver.findElement(By.id("loginpassword")).sendKeys("P@ssw0rd@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

        driver.findElement(By.xpath("//a[text()='Iphone 6 32gb']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
        WebElement productName = driver.findElement(By.xpath("//h2[text()='Iphone 6 32gb']"));
//        Assert.assertTrue(productName.isDisplayed(), "Product Name Displayed");
        WebElement productPrice = driver.findElement(By.xpath("//h3[@class='price-container']//small"));
//        Assert.assertTrue(productPrice.isDisplayed(), "Product Price Displayed");
        WebElement productDescription = driver.findElement(By.xpath("//p[contains(text(), 'It comes with 1GB of RAM.')]"));
//        Assert.assertTrue(productDescription.isDisplayed(), "Product Description Displayed");
        WebElement productImage = driver.findElement(By.xpath("//img[@src='imgs/iphone_6.jpg']"));
//        Assert.assertTrue(productImage.isDisplayed(), "Product Image Displayed");
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        String expectedAlertMessage = "Product added.";
//        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        alert.accept();
        driver.findElement(By.id("cartur")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Delete']")));
        List<WebElement> totalCartItems = driver.findElements(By.xpath("//a[text()='Delete']"));
        int totalProductCount = totalCartItems.size();
        System.out.println(totalProductCount);
        while (driver.findElements(By.xpath("//a[text()='Delete']")).size()>0){
            driver.findElement(By.xpath("//a[text()='Delete']")).click();
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//a[text()='Delete']"))));

        }

//        if (totalProductCount>1){
//            for (int i = 0; i<totalProductCount; i++){
//                driver.findElement(By.xpath("//a[text()='Delete']")).click();
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Delete']")));
//            }
//        }

//        String productPriceInCart =  driver.findElement(By.xpath("//tbody[@id='tbodyid']//tr//td[3]")).getText();
//        String totalProductPriceInCart = driver.findElement(By.id("totalp")).getText();
//        if (productPriceInCart.equals(totalProductPriceInCart)){
//            System.out.println("Both the values are equal");
//        }else {
//            System.out.println("Mismatch in the values");
//            Assert.assertFalse(false);
//        }
//        driver.quit();



    }
}
