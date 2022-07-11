
package com.excel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.UserDetails;
import com.excel.helper.Helper;
import com.excel.service.ExcelService;

@RestController
public class ExcelController {

	@Autowired	
	private ExcelService excelService;

	@PostMapping("/user/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		if (Helper.checkFormat(file)) {
			this.excelService.save(file);
			return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to DB"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
	}
 
	@GetMapping("/user/get")
	public List<UserDetails> getAllUser() {
		return this.excelService.getAllUser();
	}
}
