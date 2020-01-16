package com.lks.demo.model.strategy.type;

import com.lks.demo.model.strategy.base.Discount;

/**
 * @author likesheng
 * @Time 2019/11/7
 **/
public class SilverMember implements Discount {
    @Override
    public double dicountPrice(double money) {
        return money*0.8;
    }
}
