package Website.Cashify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class removeItem {
	
	public WebDriver driver;
	String URL = "https://getbootstrap.com/docs/4.4/examples/checkout/";
	String driverfilepath = "//Users//monikachaudhary//Downloads//chromedriver";
	@BeforeTest
	public void browserinititae(){
		System.setProperty("webdriver.chrome.driver", driverfilepath);
        driver = new  ChromeDriver();
	}
	@Test
	public void removeitem () {
		WebElement cartvalue = driver.findElement(By.xpath("//div[@class='row']//li[5]/strong"));
		WebElement discount = driver.findElement(By.xpath("xpath of webelement where coupon code amount is written"));
		driver.get(URL);
        driver.findElement(By.xpath("xpath of removed button placed on that particular item")).click();
        
        //get initial cart value after removing item
        String initialcarttotal = cartvalue.getText();
        System.out.println("Cart value is  = " + initialcarttotal);
        String Cartbeforecoupon = initialcarttotal.replace("$", "");
        double initialcartvelue = Double.parseDouble(Cartbeforecoupon);
        
       //get expected discount value
        double expecteddiscount = initialcartvelue/10; //expected 10% discount 
        
        //get given discount value
        String Discount= discount.getText();
        String alteredprice = Discount.replace("$", ""); 
        double GivenDiscountvalue = Double.parseDouble(alteredprice);    //GivenDiscountvalue =1.5
        
         
        double expectedcartvalue= initialcartvelue-expecteddiscount;
        double givencartvalue = initialcartvelue-GivenDiscountvalue;
        
        Assert.assertEquals(expectedcartvalue, givencartvalue);
        }
	    @AfterTest
	    public void driverclose() {
		driver.close();
	}

}
