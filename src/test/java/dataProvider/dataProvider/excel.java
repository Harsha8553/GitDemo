package dataProvider.dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excel {
	
	DataFormatter form=new DataFormatter();
	
	@Test(dataProvider="TestDatapro")
	public void test(String data1,String data2,String data3) {
		
		System.out.println(data1+data2+data3);
		
	}
	
	@DataProvider(name="TestDatapro")
	public Object[][] getData() throws IOException {
		
//		Object[][] data= {{"Test","come","1"},{"Test1","come1","11"},{"Test2","come2","12"}};
//		
//		return data;
		
FileInputStream file=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\dataProvider\\dataExcel.xlsx");
		
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet=work.getSheetAt(0);
		int row=sheet.getPhysicalNumberOfRows();
		
		XSSFRow rowv = sheet.getRow(0);
		int col=rowv.getLastCellNum();
		Object  data[][]=new Object[row-1][col];
		for(int i=0;i<row-1;i++) {
			rowv=sheet.getRow(i+1);
			for(int j=0;j<col;j++) {
				XSSFCell cell=rowv.getCell(j);
				
				data[i][j]=form.formatCellValue(cell);
			}
		}
		
		return data;
		
	}

}
