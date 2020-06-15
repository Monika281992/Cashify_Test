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

import elementsList.WebElements;
import junit.framework.Assert;

public class DiscountvalueChacek extends Base {
   
	WebElements se = new WebElements(driver);
	@Test
	public  void  Couponapply() {
		
	//Coupon applied	
		//intial cart value without coupon code
		String Cart = se.totalcartvalue().getText();
		String carttotal = Cart.replace("$", "");
		int Initialcartvalue=  Integer.parseInt(carttotal);  //expected 25(without pormo code)
		
		//Apply coupon
		//driver.findElement(By.xpath("xpath of removed button placed on that particular item")).click();
		se.promocode().sendKeys("cashify10");
        se.Redeem().click();
		 
		//check Given discount value
        String Discount= se.DisountAmount().getText();
        String alteredprice = Discount.replace("$", ""); 
        double GivenDiscountvalue = Double.parseDouble(alteredprice);
        
        //Expected discount value
        double expectedDiscount = (double) (Initialcartvalue*10)/100;   ///expected discount is 2.5(25*10)/100
        
		//Assert coupon applied
		Assert.assertEquals(expectedDiscount, GivenDiscountvalue);
		
	//Delete Coupn and check cart value
		se.DeleteCoupon().click();
		String cartvalue = se.totalcartvalue().getText();
		String CRTvalue = Cart.replace("$", "");
		int afterCPNcartvalue =  Integer.parseInt(CRTvalue);
		
		
		//assert on cart value after removing coupon
		Assert.assertEquals(afterCPNcartvalue, Initialcartvalue);
		
   //Remove item from cart
		se.promocode().sendKeys("cashify10");
        se.Redeem().click();
		se.remove3rditem().click(); //removed Third item
		 
		//checking cart total again
		 String totalitem = se.totalitem().getText();
		    int items =Integer.parseInt(totalitem);  
		    System.out.println("Total items in cart = " + totalitem );
		    int finalcartvalue = 0;
		    WebElement table = se.Yourcart();
		    int count =	table.findElements(By.xpath("//div[@class='row']//li//span")).size();
		    for (int i =0;i<count-1;i++) {
			 String value= table.findElements(By.xpath("//div[@class='row']//li//span")).get(i).getText();
			 String alteredvalue = value.replace("$", "");
			 int newvalue =Integer.parseInt(alteredvalue);  
			 finalcartvalue = finalcartvalue + newvalue;
		   }                                                          //finalcartvalue =  18(25-5-Discount)
		    
		
		//check discount value after removing item
	    String newdiscountvalue= se.DisountAmount().getText();
        String newprice = newdiscountvalue.replace("$", ""); 
        int newdiscount = Integer.parseInt(newprice);
        System.out.println(newdiscount);                               //discount value =2 
        
        //expected new discount
        String removedItem= se.Cost3rdItem().getText();
        String rMVDItemCost = newdiscountvalue.replace("$", ""); 
        int removedItemCost = Integer.parseInt(rMVDItemCost);
        System.out.println(removedItemCost); 
        int cart = Initialcartvalue-removedItemCost;
        int ExpectednewDiscount= cart/10;
        System.out.println(ExpectednewDiscount); // expected = 2  (20/10)
        
        //Checking if coupon amount is correct after removing item
        Assert.assertEquals(ExpectednewDiscount, newdiscount);
        
        
   }

}


	