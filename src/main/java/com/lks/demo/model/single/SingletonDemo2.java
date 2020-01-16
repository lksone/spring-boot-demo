package com.lks.demo.model.single;

/**
 * 饿汉式
 *
 * @author likesheng
 * @Time 2019/11/12
 **/
public class SingletonDemo2 {

    private static volatile SingletonDemo2 instance= new SingletonDemo2();

    private SingletonDemo2(){ }

    /**
     *
     * @return
     */
    public static synchronized SingletonDemo2 getInstance(){
        if(instance ==null){
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
