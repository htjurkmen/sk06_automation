package lecture17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PostPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/create";
    private final WebDriver driver;
    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isImageVisible() {
        try {
            WebElement image = driver.findElement(By.cssSelector("img.image-preview"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getImageName() {
        WebElement imageTextElement = driver.findElement(By.cssSelector("input.input-lg"));
        String imageName = imageTextElement.getAttribute("placeholder");
        return imageName;
    }

    public void uploadPicture(File file) {
        WebElement uploadField = driver.findElement(By.cssSelector(".file[type='file']"));
        uploadField.sendKeys(file.getAbsolutePath());
    }

    public void populatePostCaption(String caption) {
        WebElement captionElement = driver.findElement(By.name("caption"));
        captionElement.sendKeys(caption);
    }

    public void clickCreatePost() {
        WebElement createPostButton = driver.findElement(By.id("create-post"));
        createPostButton.click();
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(PostPage.PAGE_URL));
    }
}
