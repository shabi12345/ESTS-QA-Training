package util;
import util.ExcelUtils;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

	public class ExcelUtils {
	    private Workbook workbook;

	    public ExcelUtils(String filePath) {
	        try (FileInputStream fis = new FileInputStream(filePath)) {
	            workbook = WorkbookFactory.create(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<String[]> getDataFromSheet(String sheetName) {
	        List<String[]> data = new ArrayList<>();
	        Sheet sheet = workbook.getSheet(sheetName); // Get sheet by name

	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
	        }

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row
	            Row row = sheet.getRow(i);
	            int cellCount = row.getLastCellNum();
	            String[] rowData = new String[cellCount];

	            for (int j = 0; j < cellCount; j++) {
	                Cell cell = row.getCell(j);
	                rowData[j] = cell != null ? cell.toString() : ""; // Avoid NullPointerException
	            }
	            data.add(rowData);
	        }
	        return data;
	    }
	}


