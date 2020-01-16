package com.lks.demo.model.builder;

/**
 * 具体的创建对象的实现类
 *
 * @author lks
 * @Time 2019/11/13
 **/
public class ConcreteBuilderA extends Builder {

    @Override
    public void buildPartA() {
        product.setPartA("partA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("partB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("partC");
    }
}
