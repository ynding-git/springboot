package com.ynding.springboot.web.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片上传服务器并返回URL
 * @author dyn
 * @version 2019/01/22
 *
 */
@Service
public class ImageService {

	private static final String UPLOAD_URL = "http://focus-img2cdn.apps.sohuno.com/upload/upload?app_name=app";

    //private static final String FETCH_UPLOAD_URL = "http://focus-img2cdn.apps.sohuno.com/upload/fetch_upload";

    private static final int BUFF_SIZE = 1024;
    
    private static final String imageType = ".jpg";
    
    private static final String contentType = "image/jpeg";
	
    
    /**
     * 读取图片文件流上传 返回上传后的图片url
     * @param picStream
     * @param imageType
     * @param contentType
     * @return
     * @throws IOException
     */
    public String upLoadImg(InputStream picStream, String imageType, String contentType) throws IOException {
        String fileName = "img" + imageType;
        String boundry = "----WebKitFormBoundaryE19zNvXGzXaLvS5C";
        URL url = new URL(UPLOAD_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.addRequestProperty("filename", fileName);
        connection.addRequestProperty("name", fileName);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundry);
        OutputStream out = new DataOutputStream(connection.getOutputStream());
        StringBuilder sb = new StringBuilder();
        byte[] end = ("\r\n--" + boundry + "--\r\n").getBytes();
        sb.append("--");
        sb.append(boundry);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data;name=\"" + fileName + "\";filename=\"" + fileName + "\"\r\n");
        sb.append("Content-Type: " + contentType + "\r\n\r\n");
        out.write(sb.toString().getBytes());

        byte[] bytes = new byte[BUFF_SIZE];
        int len = 0;
        while ((len = picStream.read(bytes, 0, bytes.length)) > 0) {
            out.write(bytes, 0, len);
        }
        out.write(end);
        out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return getImgUrl(br.readLine(), fileName);
    }
    
    
    /**
     * @param response
     * @param fileName
     * @return
     */
    private String getImgUrl(String response, String fileName) {
        try {
            JSONObject job = new JSONObject();
            job = JSONObject.parseObject(response);
            JSONObject data = job.getJSONObject("data");
            return data.getString(fileName);
        } catch (Exception e) {
            return null;
        }
    }
}
