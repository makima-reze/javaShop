package com.example.common.constant;

/**
 * @author dai17
 * @create 2022-10-16 16:29
 */
public class ProductConstant {

    public enum StatusEnum {
        NEW_SPU(0, "新建"), SPU_UP(1, "上架"),SPU_DOWN(2,"下架");
        private int code;
        private String msg;

        StatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
