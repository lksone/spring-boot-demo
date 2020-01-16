package com.lks.demo.model.prototype;

/**
 * @author lks
 * @Time 2019/11/13
 **/
public class ProtoTypeDemo implements Cloneable {


    @Override
    public ProtoTypeDemo clone() throws CloneNotSupportedException {
        return (ProtoTypeDemo)super.clone();
    }

}
