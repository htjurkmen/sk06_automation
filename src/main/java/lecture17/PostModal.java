package lecture17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostModal {
    private final WebDriver driver;
    private final WebElement modalElement;

    public PostModal(WebDriver driver) {
        this.driver = driver;
        this.modalElement = driver.findElement(By.className("post-modal"));
    }

    public boolean isImageVisible() {
        try {
            WebElement image = modalElement.findElement(By.cssSelector(".post-modal-img img"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPostTitle() {
        WebElement postTitle = modalElement.findElement(By.className("post-title"));
        return postTitle.getText();
    }

    public String getPostUser() {
        WebElement postUser = modalElement.findElement(By.className("post-user"));
        return postUser.getText();
    }
}
