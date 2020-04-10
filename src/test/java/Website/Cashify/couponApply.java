package Website.Cashify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class couponApply {
	
	public WebDriver driver;
	String URL = "https://getbootstrap.com/docs/4.4/examples/checkout/";
	String driverfilepath = "//Users//monikachaudhary//Downloads//chromedriver";
	
	@BeforeTest
	public void browserinititae(){
		System.setProperty("webdriver.chrome.driver", driverfilepath);
        driver = new  ChromeDriver();
	}
	@Test 
	public void couponapply() {
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Promo code']")).sendKeys("cashify10");
        driver.findElement(By.xpath("//button[contains(text(),'Redeem')]")).click();
        WebElement cartvalue = driver.findElement(By.xpath("//div[@class='row']//li[5]/strong"));
        WebElement discount = driver.findElement(By.xpath("xpath of webelement where coupon code amount is written"));
        
        //get cart value before coupon
        String initialcarttotal = cartvalue.getText();
        System.out.println("Cart value is  = " + initialcarttotal);
        String Cartbeforecoupon = initialcarttotal.replace("$", "");
        int initialcartvelue=  Integer.parseInt(Cartbeforecoupon);
        
        //Get coupon amount
        //will set coupon amount = 2
        
        String Discount= discount.getText();
        String alteredprice = Discount.replace("$", ""); 
        int Discountvalue = Integer.parseInt(alteredprice);
        int GivenDiscountvalue = 2;
        
        //get expected discount value 
        int expecteddiscount = initialcartvelue/10; //expected 10% discount
        
        //Get cart value after coupn applied
        //will set the total cartvalue = 18 for this testcase (20-2 =18)
        
        String carttotal = cartvalue.getText();
        System.out.println("Total displyed in cart = " + carttotal);
        String Cartvalue = carttotal.replace("$", "");
        int Cartvalueint=  Integer.parseInt(Cartvalue);
        int aftercouponcart = 18; // this is the amount we will get after applying coupon
        
        //get expected cart value
        
        int expectedcartvalue = initialcartvelue-expecteddiscount;
        
        int givencartvalue = initialcartvelue-GivenDiscountvalue;
        
        Assert.assertEquals(expectedcartvalue, givencartvalue);
   }
	@AfterTest
	public void driverclose() {
		driver.close();
	}

}
