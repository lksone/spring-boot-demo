package com.lks.demo.model.strategy.base;

/**
 * 折扣基类
 *
 * @author likesheng
 * @Time 2019/11/7
 **/
public interface Discount {
    /**
     * 根据折扣原价返回金额
     * @param money
     * @return
     */
    double dicountPrice(double money);
}
