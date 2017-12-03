package com.playgame.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import com.playgame.util.MediaUtils;
import com.playgame.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadEditorController {
private static final Logger logger = LoggerFactory.getLogger(UploadEditorController.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@ResponseBody
	//"text/plain;charset=UTF-8 > �ѱ�� ���������� �����ϱ� ����.
	//�̹����� �����ϱ� ���ؼ� ���Ǵ� �޼���
	@RequestMapping(value="/uploadEditorForm", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadForm(MultipartFile file)throws Exception{
		ResponseEntity<String> entity;
		
		logger.info("���������̸� : " + file.getOriginalFilename());
		logger.info("���ϻ����� : " + file.getSize());
		logger.info("����contentType : " + file.getContentType());
		
		String uploadedName = UploadFileUtils.uploadEditorFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
		logger.info("uploadedName : " + uploadedName);
		
		try{		
			//http://localhost:8080�� ������ ����port�� �°� �����Ͻø� �˴ϴ�.
			entity = new ResponseEntity<String>("http://localhost:80/displayEditorFile?fileName="+uploadedName,HttpStatus.CREATED);
		}catch(Exception e){
			logger.info("���Ͼ��ε� ���� �����߻�: " + e.getMessage());
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return  entity;
	}
	
	@ResponseBody
	@RequestMapping("/displayEditorFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		//fileName = fileName.replaceAll(":", "/");

		logger.info("display FILE NAME: " + fileName);

		try {
			
			//���� Ȯ���ڸ� ã�´�.
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			logger.info("FORMAT NAME: " + formatName);
			
			//�̹���Ÿ���� ��� ������ Ÿ���� �����ش�.
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			//���� ��ġ���� ������ ã�Ƽ� �����Ѵ�.
			in = new FileInputStream(uploadPath + fileName);
			logger.info("FILE FULL NAME : " + uploadPath + fileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				//�̹����� �ƴҰ�쿡�� MIMEŸ���� �ٿ�ε� ������ ����
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}
			
			//byte[] �����Ͱ� �״�� ���۵ȴ�.
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName){
		ResponseEntity<String> entity;
		logger.info("filename : " + fileName);
		
		//�Ѿ�� �����̸��� ���ؼ� "/" -> "\"�� ����
		fileName.replace('/', File.separatorChar);
		
		//http://localhost:8080/displayEditorFile?fileName=[/2016/09/19/64d41412-d3ca-43b0-84cb-49fa25b2c603_test.png]
		String originalFileName = fileName.substring(fileName.indexOf("=")+1);
		logger.info("filename : " + originalFileName);
		
		new File(uploadPath + originalFileName).delete();
		
		try{
			entity = new ResponseEntity<String>("deleted",HttpStatus.OK);
		}catch(Exception e){
			logger.info("���� �������� �����߻� : " + e.getMessage());
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
