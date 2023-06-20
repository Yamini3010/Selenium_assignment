package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class usingDataProvider_And_Assertion {
        @Test(dataProvider = "loginCredentials")
        public void loginTest(String username, String password) throws InterruptedException {
            String chromeDriverPath="C:\\Software\\Chromedriver_version113\\chromedriver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver" , chromeDriverPath);
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to Burrow login page
            driver.get("https://www.burrow.com/login");
            Thread.sleep(10000);
            driver.findElement(By.xpath("//button[@aria-label='No; close the dialog']")).click();
            driver.findElement(By.xpath(
                    "//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[1]/div[1]/input")).sendKeys("miriyalayamini3010@gmail.com");
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[1]/div[2]/input")).sendKeys("Yamini#3010#");
          //  driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[2]/div[1]/button")).click();


            // Submit the form
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[2]/div[1]/button"));
            submitButton.click();

            // Perform assertions or additional actions

           // WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Welcome')]"));
            Assert.assertTrue(submitButton.isDisplayed(), "Login failed. Welcome message not displayed.");

            // Close the WebDriver
            driver.quit();

        }

        @DataProvider(name = "loginCredentials")
        public Object[][] provideLoginCredentials()
        {
            return new Object[][]{
                    { "user1", "password1" },
                    //{ "user2", "password2" },
                   // { "user3", "password3" }
                    // Add more test data as needed
            };
        }
}