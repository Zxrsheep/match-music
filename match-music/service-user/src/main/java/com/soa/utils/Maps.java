package com.soa.utils;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * map 工具类
 */

public class Maps {

    private Map<String,Object> paramMap = new HashMap<>();

    private Maps(){

    }
    private Maps(String key,String value){
        paramMap.put(key,value);
    }

    private Maps(String key,Object value){
        paramMap.put(key,value);
    }

    /**
     *
     * @param id 用户id
     * @return 构建maps
     */
    public static Maps build(int id){
        return new Maps("id",id);
    }

    public static Maps build(String key,Object value){
        return new Maps(key,value);
    }

    public static Maps build(){
        return new Maps();
    }

    public Maps put(String key,Object value){
        paramMap.put(key,value);
        return  this;
    }

    public Maps add(Map<String,Object> map){
        for ( Map.Entry<String,Object> entry : map.entrySet()) {
            paramMap.put(entry.getKey(),entry.getValue());
        }
        return this;
    }

    public Maps putId(int id){
        paramMap.put("id",id);
        return this;
    }

    public Map<String,Object> getMap(){
        return paramMap;
    }

    /**
     *
     * @param bean 模版参数
     * @param <T> 模版
     * @return 转换成map并返回
     */
    public <T> Map<String,Object> beanToMapForUpdate(T bean){
        if(bean != null){
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                paramMap.put("update"+upperFirstLetter(key+""),beanMap.get(key));
            }
        }
        return paramMap;
    }

    public static String upperFirstLetter(String str){
        char[] chars = str.toCharArray();
        if(chars[0]>='a' && chars[0]<= 'z'){
            chars[0] = (char)(chars[0]-32);
        }
        return new String(chars);
    }


    public <T> Map<String,Object> beanToMap(T bean){
        if(bean != null){
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                paramMap.put(key+"",beanMap.get(key));
            }
        }
        return paramMap;
    }

}
