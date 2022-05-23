package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

	//Rule-3: Extends BaseClass as mandatory
	public class StepDef1 extends Baseclass
	{	
		@Given("open {string} browser")
		public void method1(String bn)
		{
		    //define objects for 1st time
			getDriver(bn);
		}

		@Given("launch site using {string}")
		public void method2(String url) throws Exception
		{
		    driver.get(url);
		    Thread.sleep(5000);
		}

		@When("do login using {string} and {string} credentials")
		public void method3(String un, String pwd) throws Exception
		{
			obj1.fillUserName(un);
			obj1.clickHomeNext();
			obj2.fillPassword(pwd);
			obj2.clickLoginNext();
		}

		@Then("compose is displayed")
		public void method4() 
		{
		    if(obj3.isComposeDisplayed())
		    {
		    	System.out.println("Compose is displayed");
		    }
		    else
		    {
		    	System.out.println("Compose is not displayed");
		    	System.exit(0); //0 means forcibly
		    }
		}
	}

