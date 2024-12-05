package PageObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class erailpage extends Basepage {

	public erailpage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//input[@id='txtStationFrom']")
WebElement stationfield;
@FindBy(xpath="//div[@class='autocomplete']/div/div[1]")
List<WebElement>stationlist;
@FindBy(xpath="//input[@title='Select Departure date for availability']")
WebElement sortondate;
public void geturl() {
	driver.get("https://erail.in/");
}
public void clearfield() {
	stationfield.clear();
}
public void enterstationname(String name) {
	stationfield.sendKeys(name);
}
public List<String> getDropdownList() {
    List<String> dropdownTexts = new ArrayList<>(); 
    for (int i = 0; i < stationlist.size();i++) {
        dropdownTexts.add(stationlist.get(i).getText()); 
    }
    return dropdownTexts;
}
public void selectfourthstation() {
	stationlist.get(3).click();
	System.out.println(stationfield.getText());
}
public String getstationname() {
	return stationfield.getText();
}
public void selectdateafter30days() throws InterruptedException {
	sortondate.click();
	LocalDate date=LocalDate.now().plusDays(20);
	int day=date.getDayOfMonth();
	String monthYear = date.format(DateTimeFormatter.ofPattern("MMM-yy"));
	List<WebElement>months=driver.findElements(By.xpath("//table[@class='Month']/tbody/tr[1]/td"));
	for(int i=0;i<months.size();i++) {
		String currentmonth=months.get(i).getText();
		if(currentmonth.equals(monthYear)) {
			String xpath="//div[2]/center[1]/table[1]/tbody[1]/tr[1]/td[" + (i + 1) + "]/table[1]/tbody[1]/tr/td[text()='"+day+"']";
			WebElement dayelement=driver.findElement(By.xpath(xpath));
			System.out.println(dayelement.getText());
			dayelement.click();	
		    break;
		}
	}
	
}
public String getdateafterselection() {
	String selecteddate= sortondate.getAttribute("value");	
	return selecteddate.split(" ")[0];
}
}