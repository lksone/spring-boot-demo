package com.lks.demo.model.single;

/**
 * 单例模式   懒汉模式
 *
 * @author likesheng
 * @Time 2019/11/12
 **/
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    /**
     * 私有化構造函數
     */
    private SingletonDemo() {
    }

    /**
     * 实例化对象
     *
     * @return
     */
    public static synchronized SingletonDemo getInstance(){
        if(instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }
}
