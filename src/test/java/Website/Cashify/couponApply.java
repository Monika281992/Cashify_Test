// 2. apply cashify10 coupon and consider it will add 10% discount ,so check coupon amount and total price after that

package Website.Cashify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elementsList.WebElements;
import junit.framework.Assert;

public class couponApply extends Base {
	
	WebElements se = new WebElements(driver);
    @Test 
	public void couponapply() {
		
        //get cart value before coupon
        String initialcarttotal = se.totalcartvalue().getText();
        System.out.println("Cart value is  = " + initialcarttotal);
        String Cartbeforecoupon = initialcarttotal.replace("$", "");
        int initialcartvelue=  Integer.parseInt(Cartbeforecoupon);
        
        //Apply coupon
        se.promocode().sendKeys("cashify10");
        se.Redeem().click();
        //Get given discount amount
        String Discount= se.DisountAmount().getText();
        String alteredprice = Discount.replace("$", ""); 
        double GivenDiscountvalue = Double.parseDouble(alteredprice);   
       
        //get expected discount value 
        double expectedDiscount = (double) initialcartvelue/10;   ///expected discount is 2.5(25*10)/100
 
        //Assert on discount value
        Assert.assertEquals(expectedDiscount, GivenDiscountvalue);
        
        //Get cart value after coupon applied
        //will set the total cartvalue = 22.5 for this testcase (25-2.5 =22.5)
        
        String carttotal = se.totalcartvalue().getText();
        System.out.println("Total displyed in cart = " + carttotal);
        String Cartvalue = carttotal.replace("$", "");
        double aftercouponcartvalue=  Double.parseDouble(Cartvalue);   //aftercouponcart = 22.5
        
        //get expected cart value
        double expectedcartvalue = initialcartvelue-expectedDiscount;
        
        //Assert on cart value after discount
        Assert.assertEquals(expectedcartvalue, aftercouponcartvalue);
   }

}
