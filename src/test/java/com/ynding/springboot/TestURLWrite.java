package com.ynding.springboot;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 通过图片URL下载图片到本地测试
 */
public class TestURLWrite {

	public static void main(String[] args) {
		try {
			
			
			BufferedReader br = null;
			BufferedWriter bw = null;
			
			URL url2 = new URL("https://s2.mogucdn.com/mlcdn/c45406/170422_678did070ec6le09de3g15c1l7l36_750x500.jpg");
			// 打开和URL之间的连接
			URLConnection connection2 = url2.openConnection();
			
			File file = new File("D://mag.jpg");
			br = new BufferedReader(new InputStreamReader(connection2.getInputStream(), "utf-8"));
			
			
//			URL url = new URL("http://plm6otg7d.bkt.clouddn.com");
			URL url = new URL("http://localhost:8904/info");
			// 打开和URL之间的连接
			URLConnection connection = url.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "text/plain, */*; q=0.01");
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type", "application/json;UTF-8");
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.18 Safari/537.36)");
			// 建立实际的连接
			connection.connect();
			// 写入服务器
			String line = "";
			bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				bw.write(line);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
