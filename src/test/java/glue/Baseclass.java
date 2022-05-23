package glue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class Baseclass 
{
		//declare common objects as static(gets commonly sharable memory for all child classes)
		protected static RemoteWebDriver driver;
		protected static HomePage obj1;
		protected static LoginPage obj2;
		protected static ComposePage obj3;
		protected static LogoutPage obj4;
		//create a static driver
		public static void getDriver(String bn)
		{
			if(driver==null)
			{
				if(bn.equalsIgnoreCase("Chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(bn.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}	
				else
				{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
				}
				obj1=new HomePage(driver);
		    	obj2=new LoginPage(driver);
		    	obj3=new ComposePage(driver);
		    	obj4=new LogoutPage(driver);
			}
		}
}

