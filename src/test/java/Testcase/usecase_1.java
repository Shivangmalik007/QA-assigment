package Testcase;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.erailpage;
import utilities.excelutils;
@Listeners(utilities.ExtentreportManager.class)
public class usecase_1 extends Basetest {
	
@Test
public void erailusecase() throws IOException, InterruptedException {
	erailpage er=new erailpage(driver);
	er.geturl();
	er.clearfield();
	er.enterstationname("Del");
	List<String>dropdownlist=er.getDropdownList();
	er.selectfourthstation(); 
	excelutils excl=new excelutils(".\\src\\test\\resources\\testdata\\ExpectedStations.xlsx");
     for(int i=0;i<dropdownlist.size();i++) {
    	 excl.setCellData("Actualstations", i, 0, dropdownlist.get(i));
     }
     int totalrows=excl.getRowCount("ExpectedStations");
     int totalrowactual=excl.getRowCount("Actualstations");
     for(int i=0;i<=totalrows;i++) {
    String expectedvalue=excl.getCellData("ExpectedStations",i, 0);
    	for(int j=0;j<=totalrowactual;j++) {
    		String actualvalue=excl.getCellData("Actualstations", j, 0);
    		if (expectedvalue.equals(actualvalue)) {
                System.out.println("Match found: " + actualvalue);
              excl.setCellData("ExpectedStations", i, 1, "Found");  
    	}
    		else{
    			excl.setCellData("ExpectedStations",i,1,"Not Found");
    		}
 
     }
}
     er.selectdateafter30days();
     String dateafterselection=er.getdateafterselection();
     String expecteddate=LocalDate.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd-MMM-YY"));
     System.out.println(expecteddate);
     Assert.assertEquals(dateafterselection, expecteddate);
     
}
}
