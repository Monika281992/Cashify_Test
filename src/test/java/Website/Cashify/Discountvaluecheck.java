//Automated Script to check if coupon applied/removed, removing of item to cart and coupon discount

package Website.Cashify;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DiscountvalueChacek {
	
	
	
	
	String URL = "https://getbootstrap.com/docs/4.4/examples/checkout/";
	String driverfilepath = "//Users//monikachaudhary//Downloads//chromedriver";
	public WebDriver driver;
	
	@BeforeTest
	public void browserint(){
		System.setProperty("webdriver.chrome.driver", driverfilepath);
        driver = new  ChromeDriver();
	}
   
	
	@Test
	public  void  Couponapply() {
		
		driver.get(URL);
		
		//intial cart value without coupon code
		String Cart = driver.findElement(By.xpath("//div[@class='row']//li[5]/strong")).getText();
		String carttotal = Cart.replace("$", "");
		int Initialcartvalue=  Integer.parseInt(carttotal);  //expected 25(without pormo code)
		
		//Apply coupon
		driver.findElement(By.xpath("xpath of removed button placed on that particular item")).click();
		driver.findElement(By.xpath("//input[@placeholder='Promo code']")).sendKeys("cashify10");
		driver.findElement(By.xpath("//button[contains(text(),'Redeem')]")).click();
		 
		//check Given discount value
		String Discount= driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        String alteredprice = Discount.replace("$", ""); 
        int GivenDiscountvalue = Integer.parseInt(alteredprice);
        System.out.println(GivenDiscountvalue);
        
        //Expected discount value
        int ExpectedDiscount = Initialcartvalue/10;
        System.out.println(ExpectedDiscount); // expected 2.5(25/10)
        
		//Checking if coupon amount is correct
		Assert.assertEquals(ExpectedDiscount, GivenDiscountvalue);
		 
		//Remove item from cart
		 driver.findElement(By.xpath("xpath of removed button placed on that particular item")).click(); //removed Third item
		 
		//checking cart total again
		 String totalitem = driver.findElement(By.xpath("//span[@class='badge badge-secondary badge-pill']")).getText();
		    int items =Integer.parseInt(totalitem);  
		    System.out.println("Total items in cart = " + totalitem );
		    int finalcartvalue = 0;
		    WebElement table = driver.findElement(By.xpath("//div[@class='col-md-4 order-md-2 mb-4']"));
		    int count =	table.findElements(By.xpath("//div[@class='row']//li//span")).size();
		    for (int i =0;i<count-1;i++) {
			 String value= table.findElements(By.xpath("//div[@class='row']//li//span")).get(i).getText();
			 String alteredvalue = value.replace("$", "");
			 int newvalue =Integer.parseInt(alteredvalue);  
			 finalcartvalue = finalcartvalue + newvalue;
		   }                                                          //finalcartvalue =  20(25-5)
		    
		
		//check discount value after removing item
	    String newvalue= driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        String newprice = newvalue.replace("$", ""); 
        int newdiscount = Integer.parseInt(newprice);
        System.out.println(newdiscount);
        
        //expected new discount
        int ExpectednewDiscount = finalcartvalue/10;
        System.out.println(ExpectednewDiscount); // expected 2(20/10)
        
        //Checking if coupon amount is correct after removing item
        Assert.assertEquals(ExpectednewDiscount, newdiscount);
       
	}
	@AfterTest
    public void driverclose() {
	driver.close();
}

}
