import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TryToFindElements {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //disable notifications which can block elements
        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-dev-shn-usage");
        // place for headless options
        driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown(){driver.quit();}

    @Test(description = "get page elements, check and match, extract values")
    public void findElements(){

        String mainPageSource = driver.getPageSource();
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
//        WebElement menuElement = driver.findElement(By.xpath("//a[@class='menu-categories__link']/span"));

        // 1. certain element is on the page.
        Assert.assertTrue(mainPageSource.contains("Доставка по всей Украине"));
        // 2. check equality of expected and actual element (text)
        Assert.assertEquals(driver.findElement(By.xpath("//button[@aria-label='Каталог']")).getText(), "Каталог");
        // 3. check location of element
//        System.out.println(driver.findElement(By.xpath("//a[@class='menu-categories__link']/span")).getLocation());
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='menu-categories__link']/span")).getLocation().toString(), "(48, 127)");
        // 4. check the element is enabled on the page.
        Assert.assertTrue(searchField.isEnabled());
        // 5. check attribute value.
        Assert.assertEquals(searchField.getAttribute("placeholder"), "Я ищу...");
        // 6. check the amount of elements on the page.
        Assert.assertEquals(driver.findElements(By.xpath("//a[@class='menu-categories__link']/span")).size(), 16);


    }
}
