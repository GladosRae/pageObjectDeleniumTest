import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class testAliRegisterPage {
    WebDriver driver;
    RegisterPage page;

    @Before
    public void setUp() throws MalformedURLException {
        /*System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();*/

        DesiredCapabilities caps = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("localhost:4444/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://login.aliexpress.ru/?flag=1&return_url=https%3A%2F%2Fhome.aliexpress.ru%2Findex.htm%3Fspm%3Da2g2w.home.1000001.9.75df5430uSVwgI%26tracelog%3Dws_topbar%26_ga%3D2.195076588.1321411370.1634223558-767497661.1634026945");
    }

    @Test
    public void logIn() {
        page = new RegisterPage(driver);
        page.emailFieldType("lalala@ya.ru");
        page.passwordFieldType("text");
        page.signupButtonClick();
    }
    @Test
    public void logInInvalidEmail() {
        page = new RegisterPage(driver);
        page.emailFieldType("lalala@ya.ru");
        page.passwordFieldType("text");
        page.signupButtonClick();
        Assert.assertTrue(page.isErrorVisible("Ваши учетное имя или пароль неправильные."));
        Assert.assertFalse(page.isErrorVisible("Ваш email неккоректен"));
    }
    @Test
    public void recowerPassword() {
        page = new RegisterPage(driver);
        page.recowerPasswordButtonClick();
    }

    @After
    public void shoutDown() {
        driver.quit();
    }
}
