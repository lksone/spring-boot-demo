package com.lks.demo.model.single;

/**
 * 枚舉類型創建
 *
 * @author lks
 * @Time 2019/11/12
 **/
public enum SingletonEnum {
    INSTANCE;

    /**
     * 获取对象
     *
     * @return
     */
    public static SingletonEnum getInstance(){
        return SingletonEnum.INSTANCE;
    }
}
