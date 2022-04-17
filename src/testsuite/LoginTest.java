package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";//base url

    @Before //setup the browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
        //expected result
        String expected = "Welcome Back!";
        WebElement actual = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualresult = actual.getText();
        //verifying the result
        Assert.assertEquals("Verify the text", expected, actualresult);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on  sign in btn
        WebElement singInBtn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        singInBtn.click();
        //Enter username field
        WebElement usernameField = driver.findElement(By.id("user[email]"));
        usernameField.sendKeys("abc@yahoo.com");
        // Enter password Field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("Welcome22");
        //  Click sign in button
        WebElement clickBtn = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        clickBtn.click();
        String expectedMessage = "Invalid email or password.";
        //actual Text
        WebElement actualMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
