package cn.lgwen.validatorplus.core;

import com.alibaba.fastjson.JSONArray;
import com.lgwen.validatorplus.util.JSONUtil;
import com.lgwen.validatorplus.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WU on 2017/7/17.
 * 参数池，所有配置在json的参数都在这里取
 */
public class ParamPool {

    private static Map<String, Param> validMap = init();

    private static Map<String,Param> init(){
        Map<String, Param> map = new HashMap<String, Param>();
        JSONArray array = JSONUtil.getJSON();
        if(array == null || !array.isEmpty()){
            return new HashMap<String,Param>();
        }
        List<Param> params = array.toJavaList(Param.class);
        for (Param param : params) {
            Assert(param);
            map.put(param.getKey(),param);
        }
        return map;
    }

    private static void Assert(Param param){
        if(StringUtils.isBlank(param.getKey())){
            throw new IllegalArgumentException("json param must be have key");
        }
        if(StringUtils.isBlank(param.getMessage())){
            throw new IllegalArgumentException("json param must be have message");
        }
        if(StringUtils.isBlank(param.getRegexp())){
            throw new IllegalArgumentException("json param must be have regexp");
        }
    }

    public static Param keyOf(String key){
        if(validMap == null || validMap.isEmpty()){
            init();
        }
        return validMap.get(key);
    }
}
