package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orangehrm extends Basepage {

	public orangehrm(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//input[@name='username']")
WebElement username;
@FindBy(xpath="//input[@name='password']")
WebElement password;
@FindBy(xpath="//button[@type='submit']")
WebElement loginbutton;
@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
WebElement errormessage;
@FindBy(xpath="//h6[text()='Dashboard']")
WebElement dashboardtitle;
@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
WebElement profilesection;
@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li[4]")
WebElement logoutbutton;
public void geturl() {
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}
public void enterusername(String name) {
	username.sendKeys(name);
}
public void enterpassword(String psswrd) {
	password.sendKeys(psswrd);
}
public void clickonloginbutton() {
	loginbutton.click();
}
public String geterrormessage() {
	return errormessage.getText();
}
public boolean isdashboardexists() {
	try {
		return dashboardtitle.isDisplayed();
	} catch (Exception e) {
		return (false);
	}
	
}
public void logout() {
	profilesection.click();
	logoutbutton.click();
}
}
