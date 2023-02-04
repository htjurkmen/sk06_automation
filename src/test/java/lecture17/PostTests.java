package lecture17;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class PostTests extends TestObject {
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\upload\\testUpload.jpg");
        String caption = "Testing create post caption";

        return new Object[][]{{"testMail1@gmail.com", "Dimitar1.Tarkalanov1", "DimitarTarkalanov", postPicture, caption}, {"testAdmin@gmail.com", "Admin1.User1", "AdminUser", postPicture, caption}, {"manager@gmail.com", "Manager1.Use1", "ManagerUser", postPicture, caption}};
    }

    @Test(dataProvider = "getUsers")
    public void testCreatePost(String user, String password, String username, File file, String caption) {
        //Gets a driver instance from parent class (TestObject)
        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);
        //Navigate directly to Login page
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        Header header = new Header(driver);
        header.clickNewPost();

        PostPage postPage = new PostPage(driver);
        Assert.assertTrue(postPage.isUrlLoaded(), "The POST URL is not correct!");
        postPage.uploadPicture(file);
        Assert.assertTrue(postPage.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is incorrect!");
        postPage.populatePostCaption(caption);
        postPage.clickCreatePost();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        Assert.assertEquals(profilePage.getPostCount(), 1, "The number of Posts is incorrect!");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(driver);
        Assert.assertTrue(postModal.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(postModal.getPostTitle(), caption);
        Assert.assertEquals(postModal.getPostUser(), username);
    }
}
