/*
 * package com.a.b.util;
 * 
 * import java.io.File; import java.io.FileOutputStream; import
 * java.io.IOException; import java.io.OutputStream; import java.io.PrintWriter;
 * 
 * import org.springframework.stereotype.Component; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.multipart.MultipartHttpServletRequest;
 * 
 * @Component public class UtilFile { String fileName="";
 * 
 * 
 * 
 * public String fileUpload(MultipartHttpServletRequest request, MultipartFile
 * bUrl, Object obj) {
 * 
 * 
 * String path=""; String fileName="";
 * 
 * OutputStream out = null; PrintWriter printWriter = null;
 * 
 * try { fileName = bUrl.getOriginalFilename(); byte[] bytes = bUrl.getBytes();
 * path = getSaveLocation(request, obj);
 * 
 * System.out.println("파일이름:"+fileName); System.out.println("업로드 위치:"+path);
 * 
 * File file = new File(path);
 * 
 * 
 * if (fileName != null && !fileName.equals("")) { if(file.exists()) { //파일명 앞에
 * 업로드 시간 초단위를 붙여서 파일명의 중복으 방지 fileName = System.currentTimeMillis()+"_"+
 * fileName;
 * 
 * file = new File(path + fileName); } }
 * 
 * System.out.println("w중복수정후파일이름:"+fileName); System.out.println("파일:"+file);
 * 
 * out = new FileOutputStream(file);
 * 
 * System.out.println("파일 아웃:" +out);
 * 
 * out.write(bytes);
 * 
 * 
 * 
 * } catch (Exception e ) { e.printStackTrace(); } finally { try { if (out !=
 * null) { out.close(); } if (printWriter != null) { printWriter.close(); } }
 * catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * return path + fileName;
 * 
 * }
 * 
 * //업로드 파일 저장 경로를 얻는 메소드 // 업로드한 파일의 경로가 도메인 별로 달라야 했기 때문에 도메인의 형을 비교하여 파일 저장
 * 경로를 다르게 지정 private String getSaveLocation(MultipartHttpServletRequest
 * request, Object obj) {
 * 
 * String uploadPath =
 * request.getSession().getServletContext().getRealPath("/"); String attachPath
 * = "resources/files/";
 * 
 * if (obj instanceof Reward) { attachPath += "reward/";
 * 
 * } else if (obj instanceof Draft) { attachPath += "approval/"; } else {
 * attachPath += "document/"; }
 * 
 * System.out.println("겟세이브로케이션:"+uploadPath + attachPath); return uploadPath +
 * attachPath; }
 * 
 * }
 */