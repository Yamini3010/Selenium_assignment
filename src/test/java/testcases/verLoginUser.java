package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verLoginUser {
    public static void main(String[] args) throws InterruptedException {
        String ChromeDriverPath = "C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://burrow.com/login");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@aria-label='No; close the dialog']")).click();
        driver.findElement(By.xpath(
                "//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[1]/div[1]/input")).sendKeys("miriyalayamini3010@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[1]/div[2]/input")).sendKeys("Yamini#3010#");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[2]/div[1]/button")).click();

    }
}
