package com.lks.demo.model.prototype;

/**
 * @author lks
 * @Time 2019/11/13
 **/
public class ProtoTypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeDemo demo = new ProtoTypeDemo();
        ProtoTypeDemo clone = demo.clone();

        System.out.println(demo == clone);
    }
}
