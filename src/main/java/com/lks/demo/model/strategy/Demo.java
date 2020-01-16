package com.lks.demo.model.strategy;

/**
 * @author likesheng
 * @Time 2019/11/8
 **/
public class Demo {

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        double v = consumer.discountPiece(1000d, 1);
        System.out.println(v);
    }
}
