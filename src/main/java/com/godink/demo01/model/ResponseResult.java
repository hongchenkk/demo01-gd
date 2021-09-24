package com.godink.demo01.model;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.godink.demo01.enums.ResponseEnumCode;

/** 
 * @Description: 通用结果集封装类
 * @author: Hong.Chen
 * @date: 2021年9月24日 上午10:58:05 
 * @param <T>
 */
public class ResponseResult<T extends Object> {

    private Integer code;
    private T data;
    private String message;

    public ResponseResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * 失败调用
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> error(Integer code, String message) {
        return new ResponseResult<T>(code, null, message);
    }

    /**
     * 成功调用
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<T>(ResponseEnumCode.OPERATE_SUCCESS.getCode(), data, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //返回主键封装
    public static JSONObject wrapResponseMajorKeyParam(String majorKey) {
        if (StringUtils.isBlank(majorKey)) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("majorKey ", majorKey);
        return JSON.parseObject(JSON.toJSONString(map));
    }
}
