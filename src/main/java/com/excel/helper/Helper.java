package com.excel.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.UserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Helper {

	public static boolean checkFormat(MultipartFile file) {

		String contentType = file.getContentType();
		Boolean b = false;

		if (contentType != null
				&& contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			b = true;

		}

		return b;
	}

	public static List<UserDetails> convertToList(InputStream is) {
		List<UserDetails> list = new ArrayList<>();
		try {

			UserDetails details = null;

			XSSFWorkbook workbook = new XSSFWorkbook(is);

			XSSFSheet sheet = workbook.getSheet("UserData");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid = 0;
				details = new UserDetails();
				while (cells.hasNext()) {

					Cell cell = cells.next();

					switch (cid) {
					case 0:
						log.info("Cell Id : " + cell.getNumericCellValue());
						details.setId(cell.getNumericCellValue());
						break;
					case 1:
						log.info("FirstName : " + cell.getStringCellValue());
						details.setFirstName(cell.getStringCellValue());
						break;
					case 2:
						log.info("LastName : " + cell.getStringCellValue());
						details.setLastName(cell.getStringCellValue());
						break;
					case 3:
						log.info("Gender : " + cell.getStringCellValue());
						details.setGender(cell.getStringCellValue());
						break;
					case 4:
						log.info("Country : " + cell.getStringCellValue());
						details.setCountry(cell.getStringCellValue());
						break;
					case 5:
						log.info("Age : " + cell.getNumericCellValue());
						details.setAge(cell.getNumericCellValue());
						break;
					case 6:
						log.info("Date : " + cell.getStringCellValue());
						details.setDate(cell.getStringCellValue());
						break;

					default:
						break;
					}

					cid++;

				}
				list.add(details);
			}

			log.info("After   List : " + list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
