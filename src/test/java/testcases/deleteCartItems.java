package testcases;


import burrow.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class deleteCartItems {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp() throws IOException, org.json.simple.parser.ParseException {
        WebDriverManager.chromedriver().setup();
        String chromeDriverPath = "C:\\software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver", chromeDriverPath);
        String LoginDataPath = "src/main/resources/loginData.json";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        String url = (String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void deleteUser() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException {
        String searchCompDataPath="src/main/resources/loginData.json";
        FileReader fr=new FileReader(searchCompDataPath);
        JSONParser Parser=new JSONParser();
        Object ob= Parser.parse(fr);
        JSONObject jsonObject=(JSONObject) ob;
        JSONObject tc=(JSONObject) jsonObject.get("user1");
        String Username=(String) tc.get("mailId");
        String password=(String) tc.get("passWord");
        String expMsg="valid login";
        System.out.println(expMsg+" "+Username+" "+password);
        HomePage hmp = new HomePage(driver);
        hmp.emailId(Username);
        hmp.passWord(password);
        hmp.logIN();
        hmp.cart();
        hmp.Delete();
        Thread.sleep(2000);
        driver.quit();
    }

}
