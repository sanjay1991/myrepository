package glue;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

	//Rule-3: Extends BaseClass as mandatory
	public class StepDef2 extends Baseclass
	{
		@When("click on compose and fill fields and send mail and check response")
		public void method5(DataTable dt) throws Exception
		{
			//Take data from DataTable
			List<Map<String,String>> l=dt.asMaps();
			for(int i=0; i<l.size(); i++)
			{
				//Click on Compose
				obj3.clickCompose();
				//fill fields
				obj3.fillTo(l.get(i).get("to"));
				obj3.fillSubject(l.get(i).get("subject"));
				obj3.fillBody(l.get(i).get("body"));
				obj3.fillFilePath(l.get(i).get("attachment"));
				//Send mail
				obj3.clickSend();
				System.out.println(obj3.getOutputMsg());
			}
		}

		@When("do logout")
		public void method6() throws Exception
		{
			obj4.clickProfilePic();
			obj4.clickSignout(driver);
		}

		@Then("login page should be redisplayed")
		public void method7() 
		{
			if(obj4.isLoginRedisplayed())
		    {
		    	System.out.println("Successful logout");
			}
			else
			{
				System.out.println("Unsuccessful logout");
				System.exit(0); //0 means forcibly
			}
		}

		@When("close site")
		public void method8()
		{
		    driver.close();
		}
}


