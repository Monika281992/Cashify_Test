
// check total value calculated is right/wrong, 

package Website.Cashify;

import org.testng.annotations.Test;

import elementsList.WebElements;

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

public class Carttotal extends Base {
	
	WebElements se = new WebElements(driver);
	
	@Test 
	public void Cartvalue() {
		String totalitem = se.totalitem().getText();
	    int items =Integer.parseInt(totalitem);  
	    System.out.println("Total items in cart = " + totalitem );
	    int Actualtotal = 0;
	    WebElement table = se.Yourcart();
	    int count =	table.findElements(By.xpath("//div[@class='row']//li//span")).size();
	    for (int i =0;i<count-1;i++) {
		 String value= table.findElements(By.xpath("//div[@class='row']//li//span")).get(i).getText();
		 String alteredvalue = value.replace("$", "");
		 int newvalue =Integer.parseInt(alteredvalue);  
		 Actualtotal = Actualtotal + newvalue;
	   }
	   System.out.println("total = " + Actualtotal);
	   String Displayedtotal = se.totalcartvalue().getText();
	   System.out.println("Total displyed in cart = " + Displayedtotal);
	   String alteredprice = Displayedtotal.replace("$", "");
	   int DT=  Integer.parseInt(alteredprice);
	   Assert.assertTrue(DT==Actualtotal);
	   
	}
	}