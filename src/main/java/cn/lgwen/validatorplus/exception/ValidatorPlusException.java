package cn.lgwen.validatorplus.exception;

/**
 * Created by wxy on 2017/7/19.
 * 异常参数异常
 */
public class ValidatorPlusException extends RuntimeException {
    public ValidatorPlusException() {
    }
    
    public ValidatorPlusException(String message) {
        super(message);
    }
    
    public ValidatorPlusException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ValidatorPlusException(Throwable cause) {
        super(cause);
    }
    
    public ValidatorPlusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
