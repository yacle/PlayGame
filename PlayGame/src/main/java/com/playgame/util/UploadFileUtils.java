package com.playgame.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	//1.UUID�� �̿��� ������ �� ����
	//2.UUID�� ������ ���ε� ���� �̸� ����
	//3.������ ����� '/��/��/��' ���� ����
	//4.���ε� �⺻ ���(uploadPath)�� '/��/��/��' ���� ����
	//5.�⺻��� + ���ϰ�� + �����̸����� ���� ����
	public static String uploadEditorFile(String uploadPath, String originalName, byte[] fileData) throws Exception {

		//������ �ߺ��� �̸��� ���ϱ� ���� ����
		UUID uid = UUID.randomUUID();
		//128bit+'_'+���ϸ�
		String savedName = uid.toString() + "_" + originalName;
		//'uploadPath + 2016/06/10'������ ���ϸ�
		String savedPath = calcPath(uploadPath).replace(File.separator, "/");
		//������path + �������� , ���ϸ�
		File target = new File(uploadPath + savedPath, savedName);
		//������ ������ ����[����](����Ʈ������ ��ȭ�� ���� ����)
		FileCopyUtils.copy(fileData, target);
		//Ȯ���� �̸��� ��������.
		//68092a8c-5459-4e37-bf77-092035768129_�̹�����.PNG > "P"���� �ؽ�Ʈ ����
	    
	    String uploadedFileName = savedPath+"/"+savedName;
	    logger.info(uploadedFileName);
	    
	    return uploadedFileName;

	}


	private static String calcPath(String uploadPath) {
		//���� �ý����� ��¥�� �´� �����͸� ��� ����.
		Calendar cal = Calendar.getInstance();
		//������ ������ �������� '��' ���� �����Ѵ�. (File.separator: '\')
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		//'��'+'09'
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		//'��'+'09'+'19'
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		//������ ������ ��ġ�� ������� �Ѱ��ش�.
		makeDir(uploadPath, yearPath, monthPath, datePath);

		logger.info(datePath);

		return datePath;
	}

	private static void makeDir(String uploadPath, String... paths) {
		//�ش������� �����ϴ��� Ȯ���Ѵ�. \2016\09\19
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		
		for (String path : paths) {
			//paths���� ����� ���� ����ִ�./2016, /2016/09/, /2016/09/10 ������ �˻��Ѵ�.
			File dirPath = new File(uploadPath + path);
			
			//�ش糯¥�� �� ������ �������� �ʴ´ٸ� ������ �����Ѵ�.
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
}
