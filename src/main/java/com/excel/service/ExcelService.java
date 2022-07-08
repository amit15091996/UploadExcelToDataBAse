package com.excel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.UserDetails;
import com.excel.helper.Helper;
import com.excel.repo.UserRepo;

@Service
public class ExcelService {

	@Autowired
	private UserRepo repo;

	public void save(MultipartFile file) {

		try {
			List<UserDetails> user = Helper.convertToList(file.getInputStream());
			this.repo.saveAll(user);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public List<UserDetails> getAllUser() {
		return this.repo.findAll();
	}

}
