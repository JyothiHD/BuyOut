package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dataprovider {
	public static Object[][] Testdata(String sheet)
			 {
		Object[][] data = null;
		try {
			FileInputStream fs = new FileInputStream(
					"./Excel/data.xlsx");
			Workbook wb = WorkbookFactory.create(fs);
			Sheet sh = wb.getSheet(sheet);
			int r = sh.getLastRowNum();
			Row rc = sh.getRow(0);
			short cc = rc.getLastCellNum();
			data = new Object[r + 1][cc];
			for (int i = 0; i < r + 1; i++) {
				Row row = sh.getRow(i);
				for (int j = 0; j < cc; j++) {
					Cell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.println(value);
					data[i][j] = value;
				}
			}

		} catch (Exception e) {
			System.out.println("handeled");
		}
		return data;

	}

}
