package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {
    public static void captureScreenshot(String testMethodID,WebDriver driver) throws IOException {
    Date date = new Date();
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//SimpleDateFormat format =  new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String filename = date.toString().replace(":", " ");
    File dest = new File ("C:\\Users\\ADMIN\\Desktop\\Automation\\FailCases\\Test"+testMethodID+""+filename+".jpeg");
    FileHandler.copy(src, dest);
   
    }

	public static String fetchDataFromExcel(String sheetName ,int row,int cell) throws EncryptedDocumentException, IOException {
    String path = "C:\\Users\\ADMIN\\Desktop\\Automation\\Test1.xlsx" ;
    InputStream File = new FileInputStream(path);
    Workbook workbook = WorkbookFactory.create(File) ;
    Sheet sheet = workbook.getSheet(sheetName);
    
    Row row1 = sheet.getRow(row);
    Cell cell1 = row1.getCell(cell);
    String value;
    try {
	value = cell1.getStringCellValue();
	System.out.println(value);
	}
    catch(IllegalStateException e) {
    	double data = cell1.getNumericCellValue();
    	value = Double.toString(data);
    	System.out.println(value);
	 }		
    return value ;

	
	     
	}

}
