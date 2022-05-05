import jdk.jfr.internal.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args){



        System.setProperty("webdriver.chrome.driver","/C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        //driver.get("https://moodle.fel.cvut.cz/local/kos/login.php?errorcode=4");
        driver.get("https://moodle.fel.cvut.cz/auth/shibboleth/index.php");
        driver.findElement(By.id("username")).sendKeys("shorivar");
        driver.findElement(By.id("password")).sendKeys("123456");
        WebElement login = driver.findElement(By.name("_eventId_proceed"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",login);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement course = driver.findElement(By.xpath("//h5[text()='Testování softwaru']"));
        wait.until(ExpectedConditions.visibilityOf(course));
        course.click();
        WebElement cv = driver.findElement(By.xpath("//*[@id='section-4']//ancestor::div[3]/a/span"));
        wait.until(ExpectedConditions.visibilityOf(cv));
        cv.click();
        WebElement ts = driver.findElement(By.xpath("//span[text()='CV 11: Test pro Robota']"));
        wait.until(ExpectedConditions.visibilityOf(ts));
        ts.click();
        WebElement ts1 = driver.findElement(By.xpath("//div[@class='singlebutton quizstartbuttondiv']//ancestor::button"));
        wait.until(ExpectedConditions.visibilityOf(ts1));
        ts1.click();
        WebElement ts3 = driver.findElement(By.id("id_submitbutton"));
        wait.until(ExpectedConditions.visibilityOf(ts3));
        ts3.click();
        WebElement f1 = driver.findElement(By.xpath("//textarea[@class='qtype_essay_plain qtype_essay_response form-control']"));
        wait.until(ExpectedConditions.visibilityOf(f1));
        f1.sendKeys("Varvara Shorina 11 ct 16:15");
        WebElement f2 = driver.findElement(By.xpath("//span[@class='answer']//input"));
        wait.until(ExpectedConditions.visibilityOf(f2));
        f2.sendKeys("86400");
        WebElement f3 = driver.findElement(By.xpath("//p[text()='Planetou sluneční soustavy není ']//ancestor::select[@class='select custom-select custom-select place1']"));
        wait.until(ExpectedConditions.visibilityOf(f3));
        Select s = new Select(f3);
        s.selectByVisibleText("Oberon");
        WebElement f4 = driver.findElement(By.xpath("//p[text()='Mezi státy evropské unie patří ']//ancestor::select[@class='select custom-select custom-select place1']"));
        wait.until(ExpectedConditions.visibilityOf(f4));
        Select s2 = new Select(f4);
        s2.selectByVisibleText("Rumunsko");
        WebElement b0 = driver.findElement(By.xpath("//input[@name='next']"));
        wait.until(ExpectedConditions.visibilityOf(b0));
        b0.click();
        WebElement b = driver.findElement(By.xpath("//a[@id='action-menu-toggle-1']"));
        wait.until(ExpectedConditions.visibilityOf(b));
        b.click();
        WebElement b2 = driver.findElement(By.xpath( "//a[@class='dropdown-item menu-action' and @data-title='logout,moodle']"));
        wait.until(ExpectedConditions.visibilityOf(b2));
        b2.click();
        //WebElement b3 = driver.findElement(By.xpath( "//span[text()='Odhlásit se']"));
        WebElement b3 = driver.findElement(By.xpath( "//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.visibilityOf(b3));
        b3.click();
    }
}
