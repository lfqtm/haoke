package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.api.vo.PicUploadResult;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.util.internal.StringUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by nj_qlk
 */
@Service
public class PicUploadFileSystemService {

	//允许上传的文件类型
	private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};
	//本地文件存储位置
	private static final String LOCAL_IMAGE_PATH = "D:\\haoke\\haoke-upload";
	//访问

	public PicUploadResult upload(MultipartFile uploadFile) {
		//校验图片格式
		boolean isLegal = false;
		for (String type : IMAGE_TYPE) {
			if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
				isLegal = true;
				break;
			}
		}
		PicUploadResult fileUploadResult = new PicUploadResult();
		if (!isLegal) {
			fileUploadResult.setStatus("error");
			return fileUploadResult;
		}
		//文件新路径
		String filename = uploadFile.getOriginalFilename();
		String filePath = getFilePath(filename);
		//生成文件的绝对地址
		String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath, LOCAL_IMAGE_PATH), "\\", "/");
		fileUploadResult.setName("http://127.0.0.1" + picUrl);
		File newFile = new File(filePath);
		//写入磁盘
		try {
			uploadFile.transferTo(newFile);
			return fileUploadResult;
		} catch (IOException e) {
			//上传失败
			e.printStackTrace();
			fileUploadResult.setStatus("error");
			return fileUploadResult;
		}
	}

	private String getFilePath(String sourceFileName) {
		//文件上传路径
		String baseFolder = LOCAL_IMAGE_PATH + File.separator + "images";
		Date nowDate = new Date();
		String fileFolder = baseFolder + File.separator
				+ new DateTime(nowDate).toString("yyyy") + File.separator
				+ new DateTime(nowDate).toString("MM") + File.separator
				+ new DateTime(nowDate).toString("dd");

		File file = new File(fileFolder);
		if (!file.isDirectory()) {
			//如果不存在目录,则创建目录
			file.mkdirs();
		}
		//生成新的文件名
		String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS")
				+ RandomUtils.nextInt(100, 9999) + "."
				+ StringUtils.substringAfterLast(sourceFileName, ".");

		return fileFolder + File.separator + fileName;
	}
}
