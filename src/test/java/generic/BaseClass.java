package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class BaseClass {
	
	public void readExcel(String sheetName) {
		

		String currentPath = System.getProperty("user.dir");
		
		Long timeStamp = System.currentTimeMillis();
		
		currentPath = currentPath + "\\src\\test\\java\\exelData\\1515306059126.xlsx";
		File file = new File(currentPath);
		
		try {
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow row = sheet.getRow(2);
			XSSFCell cell = row.getCell(2);
			String value = cell.getStringCellValue();
			System.out.println(value);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeExcel(String sheetName) {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);
		XSSFRow row = sheet.createRow(2);
		XSSFCell cell = row.createCell(2);
		cell.setCellValue("hari");
		
		String currentPath = System.getProperty("user.dir");
		
		Long timeStamp = System.currentTimeMillis();
		
		currentPath = currentPath + "\\src\\test\\java\\exelData\\"+ timeStamp+".xlsx";
		
		File file = new File(currentPath);
		
				
		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			wb.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
