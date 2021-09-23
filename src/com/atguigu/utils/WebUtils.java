package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author LIU JIANKUN
 * @create 2021-09-11 0:19
 */
public class WebUtils {

    public static <T> T copyParaToBean(Map value , T bean){

        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, int defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
