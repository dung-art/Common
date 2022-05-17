package com.WebOfNVD.Common.Checks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checks {
	public static Boolean checkFormatDate(String dateTime) {
		// định dạng dd/MM/yyyy
		String dateTimeConvert = dateTime + " " + "00:00:00";
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime.parse(dateTimeConvert, format);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean checkStringIsFormatDate(String dateTime) throws Exception {
		try {
			if (checkFormatDate(dateTime)) {
				String a = dateTime.substring(0, 2);
				String b = dateTime.substring(3, 5);
				String c = dateTime.substring(6, 10);
				if (isInteger(a) && isInteger(b) && isInteger(c)) {
					Integer d = Integer.valueOf(a);
					Integer e = Integer.valueOf(b);
					Integer f = Integer.valueOf(c);
					if (((e == 1 || e == 3 || e == 5 || e == 7 || e == 8 || e == 10 || e == 12) && d <= 31)
							|| ((e == 4 || e == 6 || e == 9 || e == 11) && d <= 30)) {
						return true;
					} else {
						if ((f % 100 != 0 && f % 4 == 0 && e == 2 && d <= 29)
								|| (f % 100 != 0 && f % 4 != 0 && e == 2 && d <= 28)
								|| (f % 400 == 0 && e == 2 && d <= 29)
								|| (f % 100 == 0 && f % 400 != 0 && e == 2 && d <= 28)) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static Boolean isInteger(String a) throws Exception {
		try {
			if (Integer.valueOf(a) instanceof Integer) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static Boolean isSystemUserCode(String userCode) throws Exception {
		// dinh dang user he thong : SYS+
		// 01 + : Admin
		// 02 + : Manager
		// 03 + : Supporter
		try {
			if (userCode.length() == 8 && userCode.substring(0, 3).equals("SYS")
					&& (Integer.valueOf(userCode.substring(3, 5)) <= 99)
					&& (Integer.valueOf(userCode.substring(3, 5)) >= 0)
					&& (Integer.valueOf(userCode.substring(5, 8)) >= 0)
					&& (Integer.valueOf(userCode.substring(5, 8)) <= 999)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static Boolean isAdminUserCode(String userCode) throws Exception {
		// dinh dang user he thong : SYS+
		// 01 + : Admin
		// 02 + : Manager
		// 03 + : Supporter
		try {
			if (isSystemUserCode(userCode) && (Integer.valueOf(userCode.substring(3, 5)) == 1)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static Boolean isManagerUserCode(String userCode) throws Exception {
		// dinh dang user he thong : SYS+
		// 01 + : Admin
		// 02 + : Manager
		// 03 + : Supporter
		try {
			if (isSystemUserCode(userCode) && (Integer.valueOf(userCode.substring(3, 5)) == 2)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static Boolean isSupporterUserCode(String userCode) throws Exception {
		// dinh dang user he thong : SYS+
		// 01 + : Admin
		// 02 + : Manager
		// 03 + : Supporter
		try {
			if (isSystemUserCode(userCode) && (Integer.valueOf(userCode.substring(3, 5)) == 3)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static Boolean isCustomerUserCode(String userCode) throws Exception {
		// dinh dang user khach hang: CUST + ma user
		// ma user la so 8 chu so
		try {
			if (userCode.length() == 12 && userCode.substring(0, 4).equals("CUST")
					&& (Integer.valueOf(userCode.substring(4, 12)) <= 99999999)
					&& (Integer.valueOf(userCode.substring(4, 12)) >= 0)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static Boolean isPartnerUserCode(String userCode) throws Exception {
		// dinh dang user doi tac : PAR + ma doi tac + ma user
		// madoi tac la so 4 chu so
		// ma user la so 5 chu so
		try {
			if (userCode.length() == 12 && userCode.substring(0, 4).equals("PAR")
					&& (Integer.valueOf(userCode.substring(3, 7)) <= 9999)
					&& (Integer.valueOf(userCode.substring(3, 7)) >= 0)
					&& (Integer.valueOf(userCode.substring(7, 12)) <= 99999)
					&& (Integer.valueOf(userCode.substring(7, 12)) >= 0)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

//	public static File isPartode(byte[] userCode) { throws Exception {
//    BufferedImage image = new buffered;
//    byte[] imageByte = result.getResult().get(0).getImageData().getBytes();
//    ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
//    try {
//        image = ImageIO.read(bis);
//
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//    try {
//        bis.close();
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//    // write the image to a file
//    File outputfile = new File("image.jpg");
//    try {
//        ImageIO.write(image, "jpg", outputfile);
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//    return outputfile;

//	public static File img(){
//		String a = "";
//		 BufferedImage image = null;
////       byte[] imageByte = result.getResult().get(0).getImageData().getBytes();
//       byte[] imageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(a);
//       try {
//           image = ImageIO.read(new ByteArrayInputStream(imageByte));
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }
//		System.out.println(image);
//		File outputfile = new File("image.jpg");
//        try {
//            ImageIO.write(image, "jpg", outputfile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return outputfile;
//	}
}
