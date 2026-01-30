package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='modal-content']//h5[text()='Sign up']//parent::div//following-sibling::button//span[text()='×']")
    private WebElement closeIcon;

    @FindBy(xpath = "//button[text()='Sign up']//preceding-sibling::button")
    private WebElement closeButton;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignUp(){
        signUpButton.click();
    }

    public void clickCloseIcon(){
        closeIcon.click();
    }

    public void clickCloseButton(){
        closeButton.click();
    }

    public void doSignUp(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSignUp();
    }


}
