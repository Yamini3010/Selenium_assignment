package testcases;

import burrow.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class updateUser {

    WebDriver driver = null;

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
    public void updateUser() throws IOException, ParseException, InterruptedException {


        String searchCompDataPath = "src/main/resources/validLogin.json";
        FileReader fr = new FileReader(searchCompDataPath);
        JSONParser Parser = new JSONParser();
        Object ob = Parser.parse(fr);
        JSONObject jsonObject = (JSONObject) ob;
        JSONObject tc = (JSONObject) jsonObject.get("tc01");


        String Username = (String) tc.get("sText1");
        String password = (String) tc.get("sText2");
        String expMsg = "valid login";
        System.out.println(expMsg + " " + Username + " " + password);
        HomePage hmp = new HomePage(driver);
        hmp.emailId(Username);
        hmp.passWord(password);
        hmp.logIN();
        Thread.sleep(2000);
        hmp.fName("SaiRam");
        hmp.saveUpdate();
        System.out.println("Update success");
        Thread.sleep(1000);
        driver.quit();
    }
}
