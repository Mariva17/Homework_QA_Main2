import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class Registration {

    ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/C:/Program Files/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }
    @After
    public void tearDown() throws InterruptedException {
        sleep(3000); // чтоб окно браузера не сразу закрывалось, а с паузой
        driver.quit();
    }

    @Test
    public void successfullRegAllFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("Smith");
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        email.sendKeys("johnsm");
        WebElement phone = driver.findElement(By.cssSelector("input[placeholder=\'Input your phone:\']"));
        phone.sendKeys("1234567898");
        WebElement address = driver.findElement(By.cssSelector("input[placeholder=\'Input your address:\']"));
        address.sendKeys("hjjkllllll");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement headerSuccess = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", headerSuccess.getText());
        assertTrue(headerSuccess.getText().contains("Congratulations!"));

        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("registration_result"));

    }
    @Test
    public void withoutFirstName(){
        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("Smith");
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        email.sendKeys("johnsm");
        WebElement phone = driver.findElement(By.cssSelector("input[placeholder=\'Input your phone:\']"));
        phone.sendKeys("1234567898");
        WebElement address = driver.findElement(By.cssSelector("input[placeholder=\'Input your address:\']"));
        address.sendKeys("hjjkllllll");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        assertEquals("Заполните это поле.", firstNameInputField.getAttribute("validationMessage"));
    }
    @Test
    public void withoutLastName(){
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("John");
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        email.sendKeys("johnsm");
        WebElement phone = driver.findElement(By.cssSelector("input[placeholder=\'Input your phone:\']"));
        phone.sendKeys("1234567898");
        WebElement address = driver.findElement(By.cssSelector("input[placeholder=\'Input your address:\']"));
        address.sendKeys("hjjkllllll");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        assertEquals("Заполните это поле.", lastNameInputField.getAttribute("validationMessage"));
    }
    @Test
    public void withoutEmail(){
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("Smith");
        WebElement phone = driver.findElement(By.cssSelector("input[placeholder=\'Input your phone:\']"));
        phone.sendKeys("1234567898");
        WebElement address = driver.findElement(By.cssSelector("input[placeholder=\'Input your address:\']"));
        address.sendKeys("hjjkllllll");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        assertEquals("Заполните это поле.", emailField.getAttribute("validationMessage"));
    }

    @Test
    public void successRegThreeFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("Anna");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("Tompson");
        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        emailField.sendKeys("1234566gghj");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement headerSuccess = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", headerSuccess.getText());
        assertTrue(headerSuccess.getText().contains("Congratulations!"));
    }

    @Test
    public void successRegWithSpaceFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys(" ");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys(" ");
        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        emailField.sendKeys(" ");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement headerSuccess = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", headerSuccess.getText());
        assertTrue(headerSuccess.getText().contains("Congratulations!"));
    }
    @Test
    public void notSuccessRegEmptyFields() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys(" ");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("input[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("");
        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder=\'Input your email\']"));
        emailField.sendKeys("");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement headerSuccess = driver.findElement(By.tagName("h1"));
        assertNotEquals("Congratulations! You have successfully registered!", headerSuccess.getText());

    }
    @Test
    public void notSuccessRegEmptyRequiredFields() {
        WebElement phone = driver.findElement(By.cssSelector("input[placeholder=\'Input your phone:\']"));
        phone.sendKeys("1234567898");
        WebElement address = driver.findElement(By.cssSelector("input[placeholder=\'Input your address:\']"));
        address.sendKeys("hjjkllllll");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement headerSuccess = driver.findElement(By.tagName("h1"));
        assertNotEquals("Congratulations! You have successfully registered!", headerSuccess.getText());
    }

}
