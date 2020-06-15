package elementsList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements {
	
	WebDriver driver;
	public WebElements(WebDriver driver){
	this.driver=driver; 
	PageFactory.initElements(driver, this);}
	
	       //Total items
			@FindBy(xpath = "//span[@class='badge badge-secondary badge-pill']") 
		    private WebElement totalItem;
			
			public WebElement totalitem() {
		    	return totalItem;
		    }
			
			//Your cart
			@FindBy(xpath = "//div[@class='col-md-4 order-md-2 mb-4']") 
		    private WebElement Yourcart;
			
			public WebElement Yourcart() {
		    	return Yourcart;
		    }
			
			//total cart value
			@FindBy(xpath = "//div[@class='row']//li[5]/strong") 
		    private WebElement totalcartvalue;
			
			public WebElement totalcartvalue() {
		    	return totalcartvalue;
		    }
			//promo code filed
			@FindBy(xpath = "//input[@placeholder='Promo code']") 
		    private WebElement promocode;
			
			public WebElement promocode() {
		    	return promocode;
		    }
			//Redeem
			@FindBy(xpath = "//button[contains(text(),'Redeem')]") 
		    private WebElement Redeem;
			
			public WebElement Redeem() {
		    	return Redeem;
		    }
		
			//Disount Amount
			@FindBy(xpath = "//div[@class='row']//li[4]/div/following-sibling::span") 
		    private WebElement DisountAmount;
			
			public WebElement DisountAmount() {
		    	return DisountAmount;
		    }
			
			//delete coupon
			@FindBy(xpath = "xpath of deleting coupon") 
		    private WebElement DeleteCoupon;
			
			public WebElement DeleteCoupon() {
		    	return DeleteCoupon;
		    }
			//Remove 3rd item
			@FindBy(xpath = "xpath of removed button placed on that particular item") 
		    private WebElement remove3rditem;
			
			public WebElement remove3rditem() {
		    	return remove3rditem;
		    }
			
			//cost 3rd item
			@FindBy(xpath = "xpath of cost of 3rd item") 
		    private WebElement Cost3rdItem;
			
			public WebElement Cost3rdItem() {
		    	return Cost3rdItem;
		    }


}
