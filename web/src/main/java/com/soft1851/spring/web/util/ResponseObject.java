package com.soft1851.spring.web.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseObject
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/20 10:15 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseObject(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
