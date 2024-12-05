package Testcase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.orangehrm;
import utilities.Dataprovider;
@Listeners(utilities.ExtentreportManager.class)
public class usecase_2 extends Basetest {
	
	@Test(dataProvider="LoginData",dataProviderClass=Dataprovider.class)
	public void verifyloginfunctionality(String email, String password, String exp ) {
		orangehrm ohr=new orangehrm(driver);
		ohr.geturl();
		ohr.enterusername(email);
		ohr.enterpassword(password);
		ohr.clickonloginbutton();
		boolean dashboardpage=ohr.isdashboardexists();
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(dashboardpage==true)
			{
				ohr.logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(dashboardpage==true)
			{
				ohr.logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
	}

}
}