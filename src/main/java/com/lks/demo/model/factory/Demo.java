package com.lks.demo.model.factory;

/**
 * @author lks
 * @Time 2019/11/13
 **/
public class Demo {

    public static void main(String[] args) {
        System.out.println("測試開始");
        try {
            System.out.println("try");
            throw new RuntimeException("fdsafdsa");
        }catch (Exception e){
            System.out.println("cache");
        }finally {
            System.out.println("finally");
        }
    }
}
