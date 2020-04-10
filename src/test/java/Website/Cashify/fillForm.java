package Website.Cashify;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fillForm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//monikachaudhary//Downloads//chromedriver");
        WebDriver driver =new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.get("https://getbootstrap.com/docs/4.4/examples/checkout/");
        driver.findElement(By.id("firstName")).sendKeys("Monika");
        driver.findElement(By.id("lastName")).sendKeys("Chaudhary");
        driver.findElement(By.id("username")).sendKeys("ch.monika28");
        driver.findElement(By.id("address")).sendKeys("H.No-1146,sector 43");
        driver.findElement(By.id("country")).click();
        driver.findElement(By.xpath("//option[contains(text(),'United States')]")).click();
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//option[contains(text(),'California')]")).click();
        driver.findElement(By.id("zip")).sendKeys("122022");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"same-address\").click();");
        driver.findElement(By.xpath("//label[@class='custom-control-label'][contains(text(),'Credit card')]")).isEnabled();
        driver.findElement(By.id("cc-name")).sendKeys("Monika");
        driver.findElement(By.id("cc-number")).sendKeys("898967674545");
        driver.findElement(By.id("cc-expiration")).sendKeys("9/14");
        driver.findElement(By.id("cc-cvv")).sendKeys("878");
        driver.findElement(By.xpath("//button[contains(text(),'Continue to checkout')]")).submit();
        System.out.println("Form submited successfully");
        
	}

}


	