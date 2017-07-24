package cn.lgwen.validatorplus.annotation;


import cn.lgwen.validatorplus.constraintvalidator.ValidatorPlusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by WU on 2017/7/17.
 * 自定义注解 通过配置文件，注解中指定key 在配置文件中对应相应的 key message regexp
 */
@Target({ElementType.PARAMETER,ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidatorPlusValidator.class})
public @interface ValidatorPlus {
    String key();
    String message() default "";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
    String regexp() default "";
}
