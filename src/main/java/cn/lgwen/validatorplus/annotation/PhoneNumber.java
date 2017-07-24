package cn.lgwen.validatorplus.annotation;

import com.lgwen.validatorplus.constraintvalidator.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by WU on 2017/7/15.
 * 注解电话号码
 * key 对应配置文件中的 key
 * message 对应配置文件中的 message
 * type 地区标记 如中 zh_CN
 */
@Target({ElementType.PARAMETER,ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PhoneNumberValidator.class})
public @interface PhoneNumber {
    String key() default "";
    String message() default "";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
    String type() default "";
    String regexp() default "";
}
