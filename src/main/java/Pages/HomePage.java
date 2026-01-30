package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='index.html' and not(@id='nava')]")
            private WebElement homeButton;

    @FindBy(xpath = "//a[text()='Contact']")
            private WebElement contactButton;

    @FindBy(xpath = "//a[text()='About us']")
            private WebElement aboutUsButton;

    @FindBy(xpath = "//a[text()='Cart']")
            private WebElement cartButton;

    @FindBy(id = "login2")
            private WebElement loginButton;

    @FindBy(id = "signin2")
            private WebElement signUpButton;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHomeButton(){
        homeButton.click();
    }

    public void clickContactUs(){
        contactButton.click();
    }
    public void clickAboutUs(){
        aboutUsButton.click();
    }
    public void clickCartButton(){
        cartButton.click();
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickSignUp(){
        signUpButton.click();
    }


}
