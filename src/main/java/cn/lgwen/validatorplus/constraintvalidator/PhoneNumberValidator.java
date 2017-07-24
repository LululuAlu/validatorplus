package cn.lgwen.validatorplus.constraintvalidator;


import cn.lgwen.validatorplus.annotation.PhoneNumber;
import cn.lgwen.validatorplus.core.Param;
import cn.lgwen.validatorplus.core.ParamPool;
import cn.lgwen.validatorplus.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by WU on 2017/7/15.
 */
public class PhoneNumberValidator extends BaseValidator implements ConstraintValidator<PhoneNumber,String> {
    private String type;//不同地区不同校验
    private static String PHONENUMBER_REGEXP = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
    private static String PHONENUMBER_MESSAGE = "错误的手机号码";
    @Override
    public void initialize(PhoneNumber phoneNumber) {
        type = phoneNumber.type();
        message = phoneNumber.message();
        key = phoneNumber.key();
        regexp = phoneNumber.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //优先级 直接在注解内注明参数 -> 配置文件中的参数 -> 默认的参数
        if (!StringUtils.isBlank(regexp)) {
            boolean valid =  Pattern.matches(regexp, s);
            if (StringUtils.isNotBlank(message)) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            }else{
                constraintValidatorContext.buildConstraintViolationWithTemplate(PHONENUMBER_MESSAGE).addConstraintViolation();
            }
            return valid;
        }
        Param param;
        if (StringUtils.isNotBlank(this.key)) {
            param = ParamPool.keyOf(key);
        } else {
            param = ParamPool.keyOf("phoneNumber");
        }
        if(check(param)){
            constraintValidatorContext.buildConstraintViolationWithTemplate(param.getMessage()).addConstraintViolation();
            return Pattern.matches(param.getRegexp(), s);
        }
        //使用默认配置
        constraintValidatorContext.buildConstraintViolationWithTemplate(PHONENUMBER_MESSAGE).addConstraintViolation();
        return Pattern.matches(PHONENUMBER_REGEXP,s);
    }

    
}
