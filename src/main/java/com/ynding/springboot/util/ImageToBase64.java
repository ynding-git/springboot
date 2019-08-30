package com.ynding.springboot.util;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageToBase64 {
    /**
     * 将网络图片转换成base64码
     * @param netImagePath
     * @return
     */
    private static String NetImageToBase64(String netImagePath) {

//        netImagePath = "http://res.microsoul.com/" + netImagePath;//测试环境
        //netImagePath = "http://image.aipaas.com" + netImagePath;//正式环境

        ByteArrayOutputStream data = new ByteArrayOutputStream();

        try {
            URL url = new URL(netImagePath);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream is = conn.getInputStream();

            BufferedImage bi = ImageIO.read(is);
            ImageIO.write(bi,"jpg",data);

            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data.toByteArray()).replaceAll("/r/n","");
    }


    public static void main(String[] args) {

        String base64 = NetImageToBase64("http://chuantu.xyz/t6/702/1565918522x3752237043.jpg");

        System.out.println(base64);
    }


}
