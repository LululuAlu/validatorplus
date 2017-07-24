package cn.lgwen.validatorplus.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by WU on 2017/7/17.
 * classpath读取json文件
 */
public class JSONUtil {

    private static InputStream loadJSONFile(){
        InputStream in = JSONUtil.class.getClassLoader().getResourceAsStream("validatorplus.json");
        return in;
    }

    public static JSONArray getJSON() {
        StringBuilder builder = new StringBuilder();
        BufferedInputStream reader = new BufferedInputStream(loadJSONFile());
        byte[] buffer=new byte[1024];
        int flag;
        try {
            while((flag= reader.read(buffer))!=-1){
                builder.append(new String(buffer, 0, flag));
            }
        }catch (IOException e){

        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  JSONObject.parseArray(builder.toString());
    }

}
