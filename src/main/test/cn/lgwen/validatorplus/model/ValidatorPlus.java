package cn.lgwen.validatorplus.model;

import cn.lgwen.validatorplus.annotation.PhoneNumber;

/**
 * Created by laogewen on 2017/7/22.
 */
public class ValidatorPlus {
    @PhoneNumber
    private String phone;
    @cn.lgwen.validatorplus.annotation.ValidatorPlus(key = "")
    private String myValidator;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMyValidator() {
        return myValidator;
    }

    public void setMyValidator(String myValidator) {
        this.myValidator = myValidator;
    }
}
