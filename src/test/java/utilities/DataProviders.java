package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String [][] getData()
	{
		String path = ".\\testData\\LoginData.xlsx";
		
		ExcelReader xlutil = new ExcelReader(path);
		int totalrows = xlutil.getRowCount("sheet1");
		int totalcols = xlutil.getColumnCount("sheet1");
		
		//String data[][] = new String[totalrows-1][totalcols];
		String data[][] = new String[totalrows-2][totalcols];
		for (int rowNum=2; rowNum<totalrows;rowNum++)
		{
			for(int colNum=0; colNum<totalcols;colNum++)
			{
				data[rowNum-2][colNum]=xlutil.getCellData("sheet1", colNum, rowNum);
			}
		}
		
		return data;
		
		
	}

}
