package com.vst.module1.model;

/**
 * Created by zwy on 2017/12/4.
 * email:16681805@qq.com
 */

/**
 * url携带对象，对象不能序列化
 */
public class TUser {

    public String name;
    public int age;

    public TUser() {
    }

    public TUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
