package com.glodon.springboothello.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 14:53
 * @Description:
 */
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "boy")
public class BoyDomain {
    private String age;

    private Integer height;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}