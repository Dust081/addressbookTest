import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUserTest {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","PATH\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.postable.com/";
        login();
    }

    private void login() {
        driver.get("https://www.postable.com/");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("namici4743@lancastercoc.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("test12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testCase(){
        addUser();
    }

    private void addUser() {
        driver.findElement(By.xpath("//a[@href='https://www.postable.com/contacts']")).click();
        driver.findElement(By.xpath("//img[@src='/assets/images/icon_button_add_contact.svg']")).click();
        driver.findElement(By.xpath("//div[@class='small-12 columns large-3'][1]")).click();
        driver.findElement(By.xpath("//option[@value = 'Dr.']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Watson");
        driver.findElement(By.xpath("//input[@placeholder='Middle']")).sendKeys("Olegovich");
        driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("Gucon");
        new Select(driver.findElement(By.xpath("//select[@class='country']"))).selectByVisibleText("Austria");
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
