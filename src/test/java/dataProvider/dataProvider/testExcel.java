package dataProvider.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class testExcel {
	@Test
public void getData() throws IOException {
		
//		Object[][] data= {{"Test","come","1"},{"Test1","come1","11"},{"Test2","come2","12"}};
//		
//		return data;
		
		FileInputStream file=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\dataProvider\\dataExcel.xlsx");
		
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet=work.getSheetAt(0);
		int row=sheet.getPhysicalNumberOfRows();
		
		XSSFRow rowv = sheet.getRow(0);
		int col=rowv.getLastCellNum();
		for(int i=0;i<row-1;i++) {
			rowv=sheet.getRow(i+1);
			for(int j=0;j<col;j++) {
				
				System.out.println(rowv.getCell(j));
			}
		}
		
		
	}

}
