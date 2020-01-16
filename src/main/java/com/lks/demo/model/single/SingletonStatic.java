package com.lks.demo.model.single;

/**
 * 静态类型
 *
 * @author likesheng
 * @Time 2019/11/12
 **/
public class SingletonStatic {

    private SingletonStatic(){}

    /**
     * 创建
     * @return
     */
    public static SingletonStatic getInstance(){
        return InterSingleton.instance;
    }

    /**
     * 私有的静态内部类，其中只能在创建instance时调用和初始化，只有一个线程进行初始化，其他线程不能够获取
     *
     * 保证了对象的唯一性，保證了對象的唯一性（效果達到最佳）
     */
    private static class InterSingleton{
        private static final SingletonStatic instance = new SingletonStatic();
    }
}
