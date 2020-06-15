package elementsList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppElements {
	
	WebDriver driver;
	public AppElements(WebDriver driver){
	this.driver=driver; 
	PageFactory.initElements(driver, this);}

}
