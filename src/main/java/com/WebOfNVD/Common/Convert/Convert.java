package com.WebOfNVD.Common.Convert;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;

import com.WebOfNVD.Common.Checks.Checks;
import com.WebOfNVD.Common.Const.Const;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

public class Convert {
	public static byte[] ConvertImagetoByte(String pathImageFile) throws Exception {
		BufferedImage bufferedImage = ImageIO.read(new File(pathImageFile));
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, getFormatImage(pathImageFile), byteArrayOutputStream);
		byte[] dataImage = byteArrayOutputStream.toByteArray();
		return dataImage;
	}

//	public static File img(){
//	String a = "";
//	 BufferedImage image = null;
////   byte[] imageByte = result.getResult().get(0).getImageData().getBytes();
//   byte[] imageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(a);
//   try {
//       image = ImageIO.read(new ByteArrayInputStream(imageByte));
//   } catch (IOException e) {
//       throw new RuntimeException(e);
//   }
//	System.out.println(image);
//	File outputfile = new File("image.jpg");
//    try {
//        ImageIO.write(image, "jpg", outputfile);
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//    return outputfile;
//}

	public static File ConvertBytetoImage(byte[] dataImage, String nameImage) throws Exception {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataImage);
		BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
		File fileImage = new File(nameImage);
		ImageIO.write(bufferedImage, getFormatImage(nameImage), fileImage);
		return fileImage;
	}

	public static String getFormatImage(String nameImage) throws Exception {
		if (nameImage.trim().endsWith(".jpg")) {
			return "jpg";
		}
		if (nameImage.trim().endsWith(".jpeg")) {
			return "jpeg";
		}
		if (nameImage.trim().endsWith(".png")) {
			return "png";
		} else {
			throw new Exception("Định dạng không có sẵn hoặc không được hỗ trợ!");
		}
	}

	public static String ConvertPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest pass = MessageDigest.getInstance("MD5");
		byte[] pa = pass.digest(password.getBytes());
		byte[] pas = pass.digest(pa);
		String p = ConvertBytetoHex(pas);
		return p;
	}

	public static String ConvertBytetoHex(byte[] data) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			sb.append(Integer.toString((data[i] & 0xff) + 0x1211, 16).substring(1));
		}
		return sb.toString();
	}

	public static String formatLocalDateTimetoStringDateTime(LocalDateTime localDateTime) throws Exception {
		try {
			return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(localDateTime);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String formatLocalDateTimetoStringDate(LocalDateTime localDateTime) throws Exception {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").format(localDateTime);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String formatLocalDateTimetoString(LocalDateTime localDateTime, String localDateTimeFormat)
			throws Exception {
		try {
			return new SimpleDateFormat(localDateTimeFormat).format(localDateTime);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String formatDatetoStringDateTime(Date date) throws Exception {
		try {
			return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(date);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String formatDatetoStringDate(Date date) throws Exception {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").format(date);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String formatDatetoString(Date date, String dateFormat) throws Exception {
		try {
			return new SimpleDateFormat(dateFormat).format(date);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static Date convertStringDateToDate(String dateTime) throws Exception {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateTime);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("giá trị truyền không đúng");
		}
	}

	public static Date convertStringDateTimeToDate(String dateTime) throws Exception {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(dateTime);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("giá trị truyền không đúng");
		}
	}

	public static Date convertStringToDate(String dateTime, String dateFormat) throws Exception {
		try {
			return new SimpleDateFormat(dateFormat).parse(dateTime);
		} catch (Exception e) {
			throw new RuntimeException("giá trị truyền không đúng");
		}
	}

	public static LocalDateTime convertStringDateTimeToLocalDateTime(String dateTime) throws Exception {
		try {
			return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
		} catch (Exception e) {
			throw new RuntimeException("giá trị truyền không đúng");
		}
	}

	public static LocalDateTime convertStringDateToLocalDateTime(String dateTime) throws Exception {
		String dateTimeConvert = dateTime + " " + "00:00:00";
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime date = LocalDateTime.parse(dateTimeConvert, format);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("giá trị truyền không đúng");
		}
	}

	public static LocalDateTime convertStringToLocalDateTime(String dateTime, String localDateTimeFormat)
			throws Exception {
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern(localDateTimeFormat);
			LocalDateTime date = LocalDateTime.parse(dateTime, format);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("giá trị truyền không đúng");
		}
	}

	public static String getRoleOriginSystemUser(String userCode) throws Exception {
		if (Checks.isAdminUserCode(userCode)) {
			return Const.ADMIN;
		}
		if (Checks.isManagerUserCode(userCode)) {
			return Const.MANAGER;
		}
		if (Checks.isSupporterUserCode(userCode)) {
			return Const.SUPPORTER;
		} else {
			return Const.DEFAULT;
		}

	}

	public static String ConvertImageToBase64WithFormat(String imageUrl) throws Exception {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(imageUrl));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, getFormatImage(imageUrl), byteArrayOutputStream);
			byte[] dataImage = byteArrayOutputStream.toByteArray();
			String base64Data = Base64.getEncoder().encodeToString(dataImage);
			String dataI = FormatBase64(getFormatImage(imageUrl), base64Data);
			return dataI;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String ConvertImageToBase64NoFormat(String imageUrl) throws Exception {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(imageUrl));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, getFormatImage(imageUrl), byteArrayOutputStream);
			byte[] dataImage = byteArrayOutputStream.toByteArray();
			String base64Data = Base64.getEncoder().encodeToString(dataImage);
			return base64Data;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String ConvertByteArrayToBase64(byte[] data) throws Exception {
		try {
			return Base64.getEncoder().encodeToString(data);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String FormatBase64(String formatImage, String base64Data) {
		String formatBase64 = "data:image/" + formatImage + ";base64," + base64Data;
		return formatBase64;
	}

	public static String DeFormatBase64(String formatImageBase64) {
		String[] strings = formatImageBase64.split(";base64,");
		String base64 = strings[1];
		return base64;
	}

	public static byte[] ConvertBase64ToByteArray(String base64) throws Exception {
		try {
			byte[] dataI = Base64.getDecoder().decode(base64);
			return dataI;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static File ConvertBase64ToImageWithNoFormat(String formatImageBase64, String fileName) throws Exception {
		try {
			byte[] data = Base64.getDecoder().decode(formatImageBase64);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
			BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
			File fileImage = new File(fileName);
			ImageIO.write(bufferedImage, getFormatImageAdvanced(fileName), fileImage);
			return fileImage;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static File ConvertBase64ToImageWithFormat(String imageDataBase64, String fileName) throws Exception {
		try {
			String imdString = DeFormatBase64(imageDataBase64);
			byte[] data = Base64.getDecoder().decode(imdString);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
			BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
			File fileImage = new File(fileName);
			ImageIO.write(bufferedImage, getFormatImageAdvanced(fileName), fileImage);
			return fileImage;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getFormatImageAdvanced(String nameImage) throws Exception {
		if (nameImage.trim().endsWith(".jpg")) {
			return "jpg";
		}
		if (nameImage.trim().endsWith(".jpeg")) {
			return "jpeg";
		}
		if (nameImage.trim().endsWith(".png")) {
			return "png";
		}
		if (nameImage.trim().endsWith(".pdf")) {
			return "pdf";
		}
		if (nameImage.trim().endsWith(".psd")) {
			return "psd";
		}
		if (nameImage.trim().endsWith(".html")) {
			return "html";
		}
		if (nameImage.trim().endsWith(".gif")) {
			return "gif";
		}
		if (nameImage.trim().endsWith(".tiff")) {
			return "tiff";
		}
		if (nameImage.trim().endsWith(".eps")) {
			return "eps";
		}
		if (nameImage.trim().endsWith(".svg")) {
			return "svg";
		}
		if (nameImage.trim().endsWith(".raw")) {
			return "raw";
		}
		if (nameImage.trim().endsWith(".heic")) {
			return "heic";
		}
		if (nameImage.trim().endsWith(".ai")) {
			return "ai";
		}
		if (nameImage.trim().endsWith(".bmp")) {
			return "bmp";
		} else {
			throw new Exception("Định dạng không có sẵn hoặc không được hỗ trợ!");
		}
	}
}
