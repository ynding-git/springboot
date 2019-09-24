package com.ynding.springboot.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesUtil {

    private static Properties props;

    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        log.info("开始加载yml文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
            // 通过类加载器进行获取properties文件流
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream("application-dev.yml");
            props.load(in);
        } catch (FileNotFoundException e) {
            log.error("文件未找到");
        } catch (IOException e) {
            log.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("文件流关闭出现异常");
            }
        }
        log.info("加载yml文件内容完成...........");
        log.info("yml文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

    /**
     * 将json格式的字符串转换成对应的对象
     * @param propertyKey
     * @return
     */
    public static String[][] getPropertyVal(String propertyKey){

        String appGroups = getProperty(propertyKey);

        Gson gson = new Gson();

        String[][] appGroup =  gson.fromJson(appGroups,new TypeToken<String[][]>(){}.getType());
        //String[][] appGroup =  gson.fromJson(appGroups,String[][].class);

       return  appGroup;
    }


}
