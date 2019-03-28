package Lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestWeb {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private static ArrayList<String> number = new ArrayList<>();
    private static ArrayList<String> name = new ArrayList<>();
    private static ArrayList<String> gitAddress = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://121.193.130.195:8800";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.HOURS);
        GetDataFromExcel getter = new GetDataFromExcel();
        getter.analyzeExcel("/Users/houqinhan/Documents/Class/3rd/软件测试/SoftwareTest/src/Lab2/软件测试名单.xlsx", number, name, gitAddress);
    }

    @Test
    public void testWeb() throws Exception {
        driver.get(baseUrl + "/login");
        for(int i = 0; i < number.size(); i ++) {
            WebElement typeName = driver.findElement(By.name("id"));
            WebElement typePassword = driver.findElement(By.name("password"));
            typeName.sendKeys(number.get(i));
            typePassword.sendKeys(number.get(i).substring(4));
            driver.findElement(By.id("btn_login")).click();
            assertEquals(number.get(i), driver.findElement(By.id("student-id")).getText());
            assertEquals(name.get(i), driver.findElement(By.id("student-name")).getText());
            assertEquals(gitAddress.get(i), driver.findElement(By.id("student-git")).getText());
            driver.findElement(By.id("btn_logout")).click();
            driver.findElement(By.id("btn_return")).click();
        }
    }
}
