import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class RegisterPage {
     private WebDriver driver;

     public RegisterPage(WebDriver driver) {
          this.driver = driver;
     }

     private By emailField = By.xpath("//input[@id='fm-login-id']");
     private By passwordField = By.xpath("//input[@id='fm-login-password']");

     private By signUpButton = By.xpath("(//button[@type='submit'])[2]");
     private By recowerPasswordButton = By.xpath("//a[text()='Забыли пароль?']");

     String errorText = "//span[@class='fm-error-message' and text()=/'$s'/]";

     public RegisterPage emailFieldType(String email) {
          driver.findElement(emailField).sendKeys(email);
          return this;
     }

     public RegisterPage passwordFieldType(String password) {
          driver.findElement(passwordField).sendKeys(password);
          return this;
     }

     public RegisterPage signupButtonClick() {
          driver.findElement(signUpButton).click();
          return this;
     }

     public RegisterPage recowerPasswordButtonClick() {
          driver.findElement(recowerPasswordButton).click();
          return this;
     }

     public boolean isErrorVisible(String message) { // метод для проверки видимости текста ошибки
          return driver.findElements(xpath(format(errorText, message))).size() > 0;
     }
}
