package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils1 {

private static Workbook workbook;
	
	//load excel file in xlsx or xls
	
	public static void loadExcel(String filepath) {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			
			workbook = WorkbookFactory.create(fis);
			
		} catch (IOException | EncryptedDocumentException e) {
		
			throw new RuntimeException("X failed to load excel file :" + filepath, e );
		}
   }
	
	// Get row count ( excluding header row )

		public static int getRowCount(String sheetName) {
			// return workbook.getSheet(sheetName).getLastRowNum();

			Sheet sheet = workbook.getSheet(sheetName);
			return sheet.getLastRowNum();
		}

		// Get column count

		public static int getColumnCount(String ShetName) {
			// return workbook.getSheet(sheetName).getRow(0).getLastCellNum();

			Sheet sheet = workbook.getSheet(ShetName);

			return sheet.getRow(0).getLastCellNum();
		}
		
		// Get Single Sell Data

		public static String getData(String sheetName, int row, int column) {
			if (workbook == null) {
				throw new IllegalStateException(" ⚠️ Excel file not loaded . Call loadExcel() first. ");
			}

			Sheet sheet = workbook.getSheet(sheetName);
			Row r = sheet.getRow(row); // 4
			Cell cell = r.getCell(column); // 2

			DataFormatter formatter = new DataFormatter();
			return formatter.formatCellValue(cell);

		}
		
		// ✅ Read Entire sheet into 2D object array ( for DataProvider)

		public static Object[][] getSheetData(String sheetName) {
			if (workbook == null) {
				throw new IllegalStateException("⚠️ Excel file not loaded . Call loadExcel() first.");
			}

			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[rowCount][columnCount];

			DataFormatter formatter = new DataFormatter();

			// Start phone row 1 ( skip header )

			for (int i = 1; i <= rowCount; i++) {

				Row row = sheet.getRow(i);

				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = formatter.formatCellValue(cell);// data[0][0],data[0][1],data[1][0],data[1][1]
				}

			}

			return data;
		}
	
}
