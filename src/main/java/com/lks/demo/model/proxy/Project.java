package com.lks.demo.model.proxy;

/**
 * 目標對象
 * @author lks
 * @Time 2019/11/13
 **/
public class Project  implements Subject{

    @Override
    public void request(){
        System.out.println("訪問真實的對象");
    }
}
