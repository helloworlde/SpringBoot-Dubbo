package cn.com.hellowood.util;

import com.alibaba.fastjson.JSON;

/**
 * @author HelloWood
 **/
public class JSONUtil {

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

}
