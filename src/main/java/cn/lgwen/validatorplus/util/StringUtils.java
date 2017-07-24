package cn.lgwen.validatorplus.util;

/**
 * Created by WU on 2017/7/17.
 */
public final class StringUtils {

    public static boolean isBlank(String string){
        if(string == null || "".equals(string)){
            return true;
        }
        return false;
    }
    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }
}
