package com.spearmint.admin.utils;


import org.springframework.util.DigestUtils;

/**
 * @author 33992
 * @date 2019/2/27 14:13
 */
public class Md5Utils {

    private Md5Utils() {}

    public static String encrypt(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
