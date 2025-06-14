package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Latha
 */
public class ExcelUtility {
/**
 * 
 * @param sheetname
 * @param rowIndex
 * @param colIndex
 * @return value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String getStringFromExcel(String sheetname,int rowIndex,int colIndex, boolean data, int number,String date) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}
	
	/**
	 * 
	 * @param sheetname
	 * @param rowIndex
	 * @param colIndex
	 * @return Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public boolean getBooleanFromExcel(String sheetname,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis);
		return wb1.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}
	/**
	 * 
	 * @param sheetname
	 * @param rowIndex
	 * @param colIndex
	 * @return Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Date getDateFromExcel(String sheetname,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb2 = WorkbookFactory.create(fis);
		return wb2.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getDateCellValue();
	}

}
	
