package sirsiiaa.webkata.java.pojo;

import lombok.Data;

/*
 * 封装返回结果，后台对前端的响应往往会保持一个规定的格式
 * 1.
 */
@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;
}
