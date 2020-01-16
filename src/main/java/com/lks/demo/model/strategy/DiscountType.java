package com.lks.demo.model.strategy;

/**
 * @author likesheng
 * @Time 2019/11/8
 **/
public enum DiscountType {

    COMMON(1,"普通会员"),
    BRONZE(2,"青銅會員"),
    SILVER(3,"白銀會員");

    private Integer code;

    private String msg;

    DiscountType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getMesg(int key){
        for (DiscountType type:values()) {
            if(type.getCode() == key){
                return type.getMsg();
            }
        }
        return null;
    }
}
