package cn.lgwen.validatorplus.constraintvalidator;


import cn.lgwen.validatorplus.core.Param;
import cn.lgwen.validatorplus.util.StringUtils;

import javax.validation.Payload;

/**
 * Created by WU on 2017/7/18.
 * 父类 属性
 */
public class BaseValidator {
    protected String key;
    protected String message;
    protected Class<?> [] groups;
    protected Class<? extends Payload> [] payload;
    protected String regexp;
    
    protected boolean check(Param param){
        if(param == null) {
            return false;
        }
        if(StringUtils.isBlank(param.getMessage())){
            return false;
        }
        if(StringUtils.isBlank(param.getRegexp())){
            return false;
        }
        if(StringUtils.isBlank(param.getKey())){
            return false;
        }
        return true;
    }
}
