import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingRestAssured {
    public static void main(String[] args) throws InterruptedException {
        String ChromeDriverPath = "C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.burrow.com");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@aria-label='No; close the dialog']")).click();
        WebElement searchInput = driver.findElement(By.id("search-input"));
        searchInput.sendKeys("Sofa");

        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
        Response response = RestAssured.get("https://api.burrow.com/products");

        // Extract response data
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        driver.quit();
    }
}
