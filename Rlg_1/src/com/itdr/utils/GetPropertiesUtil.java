package com.itdr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesUtil {

    //获取properties文件内容
    public static String getValue(String key){
        Properties ps = new Properties();
        InputStream in = GetPropertiesUtil.
                class.getClassLoader().getResourceAsStream("const.properties");
        try {
            ps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = ps.getProperty(key);

        return value;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getValue("USER_DISABLE_CODE"));
        System.out.println(getValue("USER_DISABLE_MSG"));
    }
}
