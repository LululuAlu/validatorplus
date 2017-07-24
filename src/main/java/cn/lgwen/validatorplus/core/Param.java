package cn.lgwen.validatorplus.core;

import java.io.Serializable;

/**
 * Created by WU on 2017/7/17.
 */
public class Param implements Serializable {
    private String key;
    private String name;
    private String regexp;
    private String message;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
