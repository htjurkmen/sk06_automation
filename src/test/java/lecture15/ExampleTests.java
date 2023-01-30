package lecture15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExampleTests {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new EdgeDriver();
        this.driver.manage().window().setPosition(new Point(-1000, 0));
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void testCheckBox() {
        driver.get("https://demoqa.com/checkbox");
        WebElement label = driver.findElement(By.cssSelector("[for='tree-node-home']"));
        label.click();
        WebElement checkBox = driver.findElement(By.id("tree-node-home"));
        Assert.assertTrue(checkBox.isSelected());
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");

        //Uncheck
        label.click();
        Assert.assertFalse(checkBox.isSelected());
    }

    @Test
    public void testCheckBoxes() {
        driver.get("https://demoqa.com/checkbox");
        WebElement expandArrow = driver.findElement(By.xpath("//*[@for='tree-node-home']/preceding-sibling::button"));
        expandArrow.click();

        //Select 1st checkbox
        WebElement documentsLabel = driver.findElement(By.cssSelector("[for='tree-node-documents']"));
        documentsLabel.click();
        WebElement documentsCheckBox = driver.findElement(By.id("tree-node-documents"));
        Assert.assertTrue(documentsCheckBox.isSelected());

        //Select 2nd checkbox
        WebElement downloadsLabel = driver.findElement(By.cssSelector("[for='tree-node-downloads']"));
        downloadsLabel.click();
        WebElement downloadsCheckBox = driver.findElement(By.id("tree-node-downloads"));
        Assert.assertTrue(downloadsCheckBox.isSelected());

        //Verify 1st checkbox is still selected
        Assert.assertTrue(documentsCheckBox.isSelected());

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You have selected :\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }

    @Test
    public void testRadioButtons() {
        driver.get("https://demoqa.com/radio-button");
        WebElement yeasRadioButtonLabel = driver.findElement(By.cssSelector("[for='yesRadio']"));
        yeasRadioButtonLabel.click();
        WebElement yeasRadioButton = driver.findElement(By.id("yesRadio"));
        Assert.assertTrue(yeasRadioButton.isSelected());
        String actualText = driver.findElement(By.className("mt-3")).getText();

        Assert.assertEquals(actualText, "You have selected Yes");

        //You can select only 1 radio button
        WebElement impressiveRadioButtonLabel = driver.findElement(By.cssSelector("[for='impressiveRadio']"));
        impressiveRadioButtonLabel.click();
        WebElement impressiveRadioButton = driver.findElement(By.id("impressiveRadio"));
        Assert.assertTrue(impressiveRadioButton.isSelected());

        // The first radio button deselected
        Assert.assertFalse(yeasRadioButton.isSelected());

        actualText = driver.findElement(By.className("mt-3")).getText();
        Assert.assertEquals(actualText, "You have selected Impressive");


        WebElement noRadioButtonLabel = driver.findElement(By.cssSelector("[for='noRadio']"));
        //Click cannot select a radio button that is disabled
        noRadioButtonLabel.click();
        WebElement noRadioButton = driver.findElement(By.id("noRadio"));

        if (noRadioButton.isEnabled()) {
            Assert.assertTrue(noRadioButton.isSelected());
        } else {
            System.out.println("The NO radio button is disabled");
        }
    }

    @Test
    public void testTables() {
        driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-table"));
        int emailIndex = 0;

        //Get Column header
        WebElement tableColumnHeader = table.findElement(By.className("rt-thead"));
        List<WebElement> columnsHeaders = tableColumnHeader.findElements(By.cssSelector("[role='columnheader']"));

        for (WebElement column : columnsHeaders) {
            String columnName = column.getText();
            if (columnName.equals("Email")) {
                emailIndex = columnsHeaders.indexOf(column);
            }

            System.out.println(column.getText());
        }

        //Get Rows
        WebElement tableBody = table.findElement(By.className("rt-tbody"));
        List<WebElement> rows = tableBody.findElements(By.cssSelector("[role='row']"));

        //Find a row by email and delete it
        for (WebElement row : rows) {
            //Get Cells
            List<WebElement> cells = row.findElements(By.cssSelector("[role='gridcell']"));
            String cellText = cells.get(emailIndex).getText();
            if (cellText.equals("alden@example.com")) {
                //Delete row
                WebElement deleteButton = row.findElement(By.cssSelector("[id^=delete-record]"));
                deleteButton.click();
                break;
            }
        }

        //Get refreshed table body
        tableBody = table.findElement(By.className("rt-tbody"));
        rows = tableBody.findElements(By.cssSelector("[role='row']"));

        //Verify that the deleted row is removed
        for (WebElement row : rows) {
            //Get Cells
            List<WebElement> cells = row.findElements(By.cssSelector("[role='gridcell']"));
            String cellText = cells.get(emailIndex).getText();
            Assert.assertNotEquals(cellText, "alden@example.com");
        }
    }

    @Test
    public void testWindows() {
        driver.get("https://demoqa.com/browser-windows");
        //Uncomment to test tabs
        //WebElement button = driver.findElement(By.id("tabButton"));
        WebElement button = driver.findElement(By.id("windowButton"));
        button.click();

        //When new tab/window is opened, the driver focus remains on the initial tab/window, if no switch command is executed
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/browser-windows");

        //Get available tabs
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        String secondWindow = windows.get(1);
        //Switch the driver focus on 2nd tab
        driver.switchTo().window(secondWindow);
        driver.manage().window().maximize();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/sample");
        WebElement headline = driver.findElement(By.id("sampleHeading"));
        String actualHeadlineText = headline.getText();
        Assert.assertEquals(actualHeadlineText, "This is a sample page");

        //Switch back to first tab/window
        String firstWindow = windows.get(0);
        //Switch the driver focus on 1st tab
        driver.switchTo().window(firstWindow);
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/browser-windows");
        // driver.close() closes only the current window, but driver.quits() closes all opened windows
    }

    @Test
    public void testAlert() {
        driver.get("https://demoqa.com/alerts");

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        //Interact with alert
        Alert alert = driver.switchTo().alert();
        /*
        After switchTo().alert() we cannot interact with elements from the main window
        alertButton.getText();
         */
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, "You clicked a button");
        alert.accept();

        /*
        After alert().accept() we can interact with elements from the main window
        alertButton.getText();
         */
    }

    @Test
    public void testConfirmBox() {
        driver.get("https://demoqa.com/alerts");
        WebElement confirmBoxButton = driver.findElement(By.id("confirmButton"));
        confirmBoxButton.click();

        //Interact with ConfirmBox
        Alert alert = driver.switchTo().alert();

        //Confirm Box can be accepted or dismissed
        alert.dismiss();
        String actualMessage = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(actualMessage, "You selected Cancel");
    }

    @Test
    public void testPromptBox() {
        driver.get("https://demoqa.com/alerts");
        WebElement promptBoxButton = driver.findElement(By.id("promtButton"));
        promptBoxButton.click();

        String name = "Dimitar";

        //Interact with PromptBox
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();

        String actualText = driver.findElement(By.id("promptResult")).getText();
        String expectedText = "You entered " + name;
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testHoover() {
        driver.get("https://demoqa.com/tool-tips");
        WebElement element = driver.findElement(By.id("toolTipButton"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String tooltipText = driver.findElement(By.className("tooltip-inner")).getText();
        Assert.assertEquals(tooltipText, "You hovered over the Button");
    }

    @Test
    public void testIFrames() {
        driver.get("https://demoqa.com/frames");

        //Find all iframes
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        /*
        iframe content is available after switch
        cannot execute before switch driver.findElement(By.id("sampleHeading")).getText();
        */
        //Switch by iframe name or id
        driver.switchTo().frame("frame1");
        String frameHeadingText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(frameHeadingText, "This is a sample page");

        /*
        While driver is switched to particular frame the other page content is unavailable
        driver.findElement(By.cssSelector("#framesWrapper div")).getText();
         */

        //Go back to main page
        driver.switchTo().defaultContent();
        String mainPageText = driver.findElement(By.cssSelector("#framesWrapper div")).getText();
        Assert.assertEquals(mainPageText, "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below");

        //Switch to 3rd frame by index
        driver.switchTo().frame(2);
        frameHeadingText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(frameHeadingText, "This is a sample page");

        //Switch to 2nd frame by WebElement
        driver.switchTo().defaultContent();
        iframes = driver.findElements(By.tagName("iframe"));
        WebElement iframeElement = iframes.get(1);
        driver.switchTo().frame(iframeElement);
        frameHeadingText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(frameHeadingText, "This is a sample page");
    }
}
