// check total value calculated is right/wrong, 

package Website.Cashify;

import org.testng.annotations.Test;
import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Carttotal {
	
	public WebDriver driver;
	String URL = "https://getbootstrap.com/docs/4.4/examples/checkout/";
	String driverfilepath = "//Users//monikachaudhary//Downloads//chromedriver";
	@BeforeTest
	public void browserinititae(){
		System.setProperty("webdriver.chrome.driver", driverfilepath);
        driver = new  ChromeDriver();
	}
	@Test 
	public void Cartvalue() {
		driver.get(URL);
		String totalitem = driver.findElement(By.xpath("//span[@class='badge badge-secondary badge-pill']")).getText();
	    int items =Integer.parseInt(totalitem);  
	    System.out.println("Total items in cart = " + totalitem );
	    int Actualtotal = 0;
	    WebElement table = driver.findElement(By.xpath("//div[@class='col-md-4 order-md-2 mb-4']"));
	    int count =	table.findElements(By.xpath("//div[@class='row']//li//span")).size();
	    for (int i =0;i<count-1;i++) {
		 String value= table.findElements(By.xpath("//div[@class='row']//li//span")).get(i).getText();
		 String alteredvalue = value.replace("$", "");
		 int newvalue =Integer.parseInt(alteredvalue);  
		 Actualtotal = Actualtotal + newvalue;
	   }
	   System.out.println("total = " + Actualtotal);
	   String Displayedtotal = driver.findElement(By.xpath("//div[@class='row']//li[5]/strong")).getText();
	   System.out.println("Total displyed in cart = " + Displayedtotal);
	   String alteredprice = Displayedtotal.replace("$", "");
	   int DT=  Integer.parseInt(alteredprice);
	   Assert.assertTrue(DT==Actualtotal);
	   
	}
	@AfterTest
	public void driverclose () {
		driver.close();
	}
	
	}
		     
		      
		
	
	

  
