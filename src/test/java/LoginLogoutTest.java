import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLogoutTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup (){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test (priority = 1, description = "login and check elements")
    public void testlogin (){
        //define elements
        WebElement LoginField = driver.findElement(By.cssSelector("#txtUsername") );
        WebElement PasswordField = driver.findElement(By.cssSelector("#txtPassword"));
        WebElement SubmitButton = driver.findElement(By.cssSelector("#btnLogin"));
        //WebElement invalidcredentials = driver.findElement(by.xpath"//*[@id=\"spanMessage\"]");

        //login and check
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        LoginField.sendKeys("Admin");
        PasswordField.sendKeys("admin123");
        SubmitButton.click();

        //Assert.

}
}
