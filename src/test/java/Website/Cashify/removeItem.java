
//-3 consider there is a button next to every cart item that can remove items from the cart. remove one item and check the discount

package Website.Cashify;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class removeItem extends Base {
	
	
	@Test
	public void removeitem () {
		WebElement cartvalue = driver.findElement(By.xpath("//div[@class='row']//li[5]/strong"));
		WebElement discount = driver.findElement(By.xpath("xpath of webelement where coupon code amount is written"));
        driver.findElement(By.xpath("xpath of removed button placed on that particular item")).click(); //removed Third item
        
        //get initial cart value after removing item
        String initialcarttotal = cartvalue.getText();
        System.out.println("Cart value is  = " + initialcarttotal);
        String Cartbeforecoupon = initialcarttotal.replace("$", "");
        int initialcartvelue = Integer.parseInt(Cartbeforecoupon); //Cart Total will be 20
        
       //get expected discount value
        int expecteddiscount = initialcartvelue/10; //expected 10% discount 
        
        //get given discount value
        String Discount= discount.getText();
        String alteredprice = Discount.replace("$", ""); 
        int GivenDiscountvalue = Integer.parseInt(alteredprice);    
        
         
        int expectedcartvalue= initialcartvelue-expecteddiscount;
        int givencartvalue = initialcartvelue-GivenDiscountvalue;
        
        Assert.assertEquals(expectedcartvalue, givencartvalue);
        }

}
