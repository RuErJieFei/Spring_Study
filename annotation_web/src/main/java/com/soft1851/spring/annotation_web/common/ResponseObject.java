package com.soft1851.spring.annotation_web.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseObject
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 10:01 上午
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
