package com.lks.demo.model.strategy.type;

import com.lks.demo.model.strategy.base.Discount;

/**
 * 青銅會員
 *
 * @author likesheng
 * @Time 2019/11/7
 **/
public class BronzeMember implements Discount {

    @Override
    public double dicountPrice(double money) {
        return money*8.8;
    }
}
