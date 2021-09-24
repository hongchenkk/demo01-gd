package com.godink.demo01.enums;

/**
 * 通用响应码枚举类
 * @author Hong.Chen
 * @date 2021-09-24 10:52:54  
 * @param code
 * @return 
 * @return ResponseEnumCode
 */
public enum ResponseEnumCode {

    OPERATE_SUCCESS(200,"操作成功"),
    SYSTEM_ERROR(201,"系统错误，请联系管理员"),
	TOKEN_INVALIDATION(202,"token已失效"),
	TOKEN_ACCESS_SYSTEM_NOT_ON(203,"未授权"),
	TOKEN_ACCESS_SYSTEM_NOT_FOUND(204,"接入信息未找到"),
	TOKEN_APP_SECRET_NOT_MATCH(205,"接入AppSecret不匹配"),
    ATTACHMENT_FILENAME_IS_EMPTY(301,"附件名称为空");

    private Integer code;
    private String msg;

    ResponseEnumCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static ResponseEnumCode getResponseEnumCode(Integer code){
        for (ResponseEnumCode responseEnumCode :ResponseEnumCode.values()) {
            if (responseEnumCode.code.equals(code)){
                return responseEnumCode;
            }
        }
        return null;
    }

}
