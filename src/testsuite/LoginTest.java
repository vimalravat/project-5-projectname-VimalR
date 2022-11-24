package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


        String baseUrl = "https://courses.ultimateqa.com/ ";

        //  String baseUrl =  "https://courses.ultimateqa.com/ /";

        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }
@Test
public void userShouldNavigateToLoginPageSuccessfully(){
           // clickOnElement(By.xpath("//a[contains(text(),'Sign In')]");
    clickOnElement(By.linkText("Sign In"));
    String expectMessage = "Welcome Back!";

    //Find the text element and get the text
    WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
    String actualMessage = actualTextMessageElement.getText();

    // Validate actual and expected message
    Assert.assertEquals("Not navigate to register page", expectMessage, actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
            // click on sign in
        clickOnElement(By.linkText("Sign In"));
        // enter invalid email
        sendTextToElements(By.id("user[email]"), "Prime123456@gmail.com");
        // enter invalid password
        sendTextToElements(By.id("user[password]"), "Prime1234");
        // Click on sign in button
        clickOnElement(By.xpath("//input[@type='submit']"));

        // Expected message
        String expectMessage = "Invalid email or password.";

        //Find the text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectMessage, actualMessage);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
