package com.lks.demo.model.single;

/**
 *  懒加载构造函数
 *
 * @author likesheng
 * @Time 2019/11/12
 **/
public class SingleMain {

    public static void main(String[] args) {

        /**
         * 创建对象
         *
         */
        for (int i =0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonDemo instance = SingletonDemo.getInstance();
                    System.out.println("实例化对象--》"+instance);
                }
            }).start();
        }

    }
}
