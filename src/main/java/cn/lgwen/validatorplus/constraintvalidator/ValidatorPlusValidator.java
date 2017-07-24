package cn.lgwen.validatorplus.constraintvalidator;


import cn.lgwen.validatorplus.annotation.ValidatorPlus;
import cn.lgwen.validatorplus.core.Param;
import cn.lgwen.validatorplus.core.ParamPool;
import cn.lgwen.validatorplus.exception.ValidatorPlusException;
import cn.lgwen.validatorplus.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by wxy on 2017/7/19.
 * 提供自定义的 注解 在 json 指定(必带) key message regexp
 */
public class ValidatorPlusValidator extends BaseValidator implements ConstraintValidator<ValidatorPlus,String> {
    
    @Override
    public void initialize(ValidatorPlus validatorPlus) {
        this.key = validatorPlus.key();
        this.message = validatorPlus.message();
        this.regexp = validatorPlus.regexp();
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isNotBlank(message) && StringUtils.isNotBlank(regexp)){
            constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return Pattern.matches(regexp,s);
        }
        if(StringUtils.isBlank(key)){
            throw new ValidatorPlusException("missing keyword key,check your annotation ValidatorPlus");
        }
        Param param = ParamPool.keyOf(key);
        if(!check(param)){
            throw new ValidatorPlusException("missing json fragment of key is " + key + ",check your validatorplus.json");
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate(param.getMessage()).addConstraintViolation();
        return Pattern.matches(param.getRegexp(),s);
    }
}
