package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	//Define Element Locators
		@FindBy(xpath="//a[starts-with(@aria-label,'Google Account')]/img")
		public WebElement profilepic;
		@FindBy(linkText="Sign out") public WebElement signout;
		@FindBy(xpath="//span[text()='Choose an account']") public WebElement relogin;	
		//Constructor method
		public LogoutPage(RemoteWebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Operational and observation methods
		public void clickProfilePic() throws Exception
		{
			profilepic.click();
			Thread.sleep(5000);
		}
		public void clickSignout(RemoteWebDriver driver) throws Exception
		{
			try
			{
				signout.click();
			}
			catch(Exception ex)
			{
				//Sometimes "Sign out" is coming as <div> under <a> under 3rd frame in page 
				driver.switchTo().frame(2); //3rd frame
				driver.findElement(By.xpath("//div[text()='Sign out']/..")).click();			
			}
			Thread.sleep(5000);
		}
		public boolean isLoginRedisplayed()
		{
			if(relogin.isDisplayed())
			{
				return(true);
			}
			else
			{
				return(false);
			}
		}
	
		}
