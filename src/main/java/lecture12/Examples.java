package lecture12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Examples {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
    }

    private static void testMyFirstWebDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();
        driver.close();
    }

    private static void testFindElement() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4200/posts/all");
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.id("nav-link-login"));
        driver.close();
    }

    private static void testFindElement1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        //Finds Login link which you can use to interact with on a later stage
        WebElement loginElement = driver.findElement(By.id("nav-link-login"));

        //Finds Home link which you can use to interact with on a later stage
        WebElement homeElement = driver.findElement(By.linkText("Home"));

        driver.close();
    }

    private static void testFindElements() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Finds all posts elements
        List<WebElement> posts = driver.findElements(By.xpath("//*[@class='post-feed-img']"));
        System.out.println("The number of post elements is: " + posts.size());
        driver.close();
    }

    private static void testClick() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement login = driver.findElement(By.id("nav-link-login"));

        login.click();

        driver.close();
    }

    private static void testSendKeys() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));

        //type in username field
        username.sendKeys("test");
        driver.close();
    }

    private static void testClear() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));

        //type in username field
        username.sendKeys("test");
        username.clear();

        driver.close();
    }

    private static void testCommonCommands() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        //return title of the page as a string
        String titleOfThePage = driver.getTitle();
        System.out.println("The title is: " + titleOfThePage);

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        WebElement rememberMe = driver.findElement(By.xpath("//input[@formcontrolname='rememberMe']"));
        rememberMe.click();

        //return true if element is selected(checked)
        System.out.println("Element is selected: " + rememberMe.isSelected());

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        //return text of the field as a string
        String buttonText = signInButton.getText();
        System.out.println("The text of the element is: " + buttonText);

        //return true if element is displayed on the page
        System.out.println("The element is displayed: " + signInButton.isDisplayed());

        //return true if element is enabled, and you can interact with it
        System.out.println("The element is enabled: " + signInButton.isEnabled());
        driver.close();
    }

    private static void testDropdowns() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mobile.bg/pcgi/mobile.cgi");

        //Select value from dropdown
        Select dropdownMarka = new Select(driver.findElement(By.name("marka")));
        dropdownMarka.selectByVisibleText("Volvo");
        driver.close();
    }
}
