package cn.lgwen.validatorplus.util;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by laogewen on 2017/7/22.
 * 校验的类
 */
public class ValidatorPlus {

    public static String validateToString(Object obj){
        StringBuffer buffer = new  StringBuffer( 64 ); //用于存储验证后的错误信息
        Set<ConstraintViolation<Object>> constraintViolations = constraintViolation(obj);
        Iterator<ConstraintViolation<Object>> iter = constraintViolations
                .iterator();
        while  (iter.hasNext()) {
            String message = iter.next().getMessage();
            buffer.append(message);
        }
        return  buffer.toString();
    }



    private static Set<ConstraintViolation<Object>> constraintViolation(Object object){
        Validator validator = Validation.buildDefaultValidatorFactory()
                .getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(object);//验证某个对象,，其实也可以只验证其中的某一个属性的
        return constraintViolations;
    }

    public static void validate(Object obj){
        Set<ConstraintViolation<Object>> constraintViolation = constraintViolation(obj);
        if(constraintViolation != null && !constraintViolation.isEmpty()){
            throw new ConstraintViolationException(constraintViolation);
        }
    }
}
