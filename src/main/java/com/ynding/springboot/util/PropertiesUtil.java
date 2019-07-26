package com.ynding.springboot.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 根据属性文件名获取属性
	 * @param propertiesName
	 * @return
	 * @throws RuntimeException
	 */
	public static Properties getProperties(String propertiesName) throws RuntimeException {
        Properties properties = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ignore) {
            }
        }
        return properties;
    }
	
    /**
     * 描述：获取properties
     * @return
     * @throws RuntimeException
     */
    public static Properties getProperties() throws RuntimeException {
        Properties properties = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("test.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ignore) {
            }
        }
        return properties;
    }


    /**
     * 将json格式的字符串转换成对应的对象
     * @param propertyKey
     * @return
     */
    public static String[][] getPropertyVal(String propertyKey){

        Properties properties = getProperties();

        String appGroups = (String) properties.get("appGroups");

        Gson gson = new Gson();

       String[][] appGroup =  gson.fromJson(appGroups,new TypeToken<String[][]>(){}.getType());
//       String[][] appGroup =  gson.fromJson(appGroups,String[][].class);

       return  appGroup;
    }


}
