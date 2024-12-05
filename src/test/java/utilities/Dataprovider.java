package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\src\\test\\resources\\testdata\\hrmdata.xlsx";
		
		excelutils xlutil=new excelutils(path);
		
		int totalrows=xlutil.getRowCount("hrmlogindata");	
		int totalcols=xlutil.getCellCount("hrmlogindata",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcols;j++)  
			{
				logindata[i-1][j]= xlutil.getCellData("hrmlogindata",i, j); 
			}
		}
	return logindata;
				
	}

}
