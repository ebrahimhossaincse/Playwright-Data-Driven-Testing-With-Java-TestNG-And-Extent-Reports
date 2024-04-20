package ebrahim.hossain.sqa.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	public static String user_email;
	public static String user_pass;

	@SuppressWarnings("resource")
	public void ReadExcelData(String userRole) throws IOException {
		String excelFilePath = "./TestData/TestData.xlsx";
		File file = new File(excelFilePath);
		System.out.println(file.getAbsolutePath());
		FileInputStream inputStram = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStram);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();

		String user_role = null;

		for (int r = 1; r < rows + 1; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);
				user_role = cell.getStringCellValue();

				if (user_role.equals(userRole)) {
					row = sheet.getRow(r);
					cell = row.getCell(c + 1);
					user_email = cell.getStringCellValue();

					cell = row.getCell(c + 2);
					user_pass = cell.getStringCellValue();
				}
			}
		}
	}
}
