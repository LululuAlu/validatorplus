## 基于JSR-303 基于配置文件的校验方法
### 依赖
* validatino-api
* hibernate-validator
### 目的
通过使用同一份json配置文件达到多出正则一致的目的。 
validatorplus 设计原理，扩展javax.validation 支持目前常见的字符串 如手机号码 邮箱等。  
配置文件json 格式  
```
[
    {
        key:"phoneNumber",
        message:"校验不通过的提示",
        regexp:"/*"
    }
]
```
将文件命名为validatorplus.json，放在classpath下 如果程序没有读取到配置文件，会启用缺省的正则表达式。  
支持自定义的注解配置 使用@ValidatorPlus(key="myValidatorKey")。  
只需要再配置文件中 加入  
```
{
   key:"myValidatorKey",
   message:"校验不通过的提示",
   regexp:"/*"
}
```
