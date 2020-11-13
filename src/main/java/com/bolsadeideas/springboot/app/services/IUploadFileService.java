package com.bolsadeideas.springboot.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public String copy (MultipartFile file) throws IOException;
	
	public boolean delete(String file);
	
}
