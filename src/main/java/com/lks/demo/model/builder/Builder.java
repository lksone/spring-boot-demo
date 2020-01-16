package com.lks.demo.model.builder;

/**
 * 创建对象的抽象类
 *
 * @author lks
 * @Time 2019/11/13
 **/
public abstract class Builder {


    protected Product product = new Product();


    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
