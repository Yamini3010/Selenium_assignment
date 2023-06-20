package burrow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    WebDriver driver = null;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void emailId(String eid)
    {
        String Loc = "//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[1]/div[1]/input";
        WebElement elem = this.driver.findElement(By.xpath(Loc));
        elem.sendKeys(eid);
    }
    public void passWord(String pwd)
    {
        String Loc = "//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[1]/div[2]/input";
        WebElement elem = this.driver.findElement(By.xpath(Loc));
        elem.sendKeys(pwd);
    }
    public void logIN() {
        String Loc = "//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div/div/fieldset/form/div[2]/div[1]/button";
        WebElement elem = this.driver.findElement(By.xpath(Loc));
        elem.click();
    }
    public void fName(String str)
    {
        String Loc="//input[@value='Yamini']";
        WebElement elem = this.driver.findElement(By.xpath(Loc));
        elem.click();
        elem.clear();
        elem.sendKeys("saiRam");

    }
    public void saveUpdate()
    {
        String Loc="//button[@type='submit']";
        WebElement elem = this.driver.findElement(By.xpath(Loc));
        elem.click();
    }
    public void cart()
    {
        String Loc="//button[@class='icon icon-cart']";
        WebElement elem=this.driver.findElement(By.xpath(Loc));
        elem.click();
    }

    public void Delete()
    {
        String Loc="//button[@class='body-small cart-item__remove cart-item__button clickable']";
        WebElement elem=this.driver.findElement(By.xpath(Loc));
        elem.click();
    }


}
