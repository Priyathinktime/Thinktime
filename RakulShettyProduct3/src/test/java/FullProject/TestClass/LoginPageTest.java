package FullProject.TestClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import FullProject.PageObject.LoginPage;

public class LoginPageTest extends BaseTest {


@DataProvider(name = "getLoginData")
public Object[][] getLoginData() throws IOException {
	 FileInputStream inputStream = new FileInputStream("C:\\Users\\admin\\Documents\\login page.xlsx");
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet sheet = workbook.getSheetAt(0);

	    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1; // Including header row

	    List<Object[]> dataList = new ArrayList<>();

	    for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header
	        Row row = sheet.getRow(i);

	        if (row != null) { // Check if the row is not null
	            Cell emailCell = row.getCell(1); // Email column
	            Cell passwordCell = row.getCell(2); // Password column

	            String email = null;
	            String password = null;

	            if (emailCell != null && emailCell.getCellType() == CellType.STRING) {
	                email = emailCell.getStringCellValue();
	            }

	            if (passwordCell != null) {
	                if (passwordCell.getCellType() == CellType.STRING) {
	                    password = passwordCell.getStringCellValue();
	                } else if (passwordCell.getCellType() == CellType.NUMERIC) {
	                    password = String.valueOf((int) passwordCell.getNumericCellValue());
	                }
	            }

	            if (email != null || password != null) {
	                dataList.add(new Object[]{email, password});
	            }
	        }
	    }

	    workbook.close();
	    inputStream.close();

	    return dataList.toArray(new Object[0][]);
	}
@Test(dataProvider = "getLoginData")
public void loginTest(String email, String password) throws IOException {
	LoginPage lp = new LoginPage(getDriver());
	lp.GoTo();
    lp.login(email, password);
    Assert.assertEquals("Incorrect email or password.",lp.ErrorMassage());

}
}