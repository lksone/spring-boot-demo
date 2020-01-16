package com.lks.demo.model.strategy;

import com.lks.demo.model.strategy.base.Discount;
import com.lks.demo.model.strategy.factory.DiscountFactory;

/**
 * @author likesheng
 * @Time 2019/11/7
 **/
public class Consumer {

    public Discount discount;

    /**
     * 通過工廠的方式獲取創建的類型
     *
     * @param amount
     * @param type
     * @return
     */
    public double discountPiece(double amount,Integer type){
        discount =  DiscountFactory.create(type);
        return discount.dicountPrice(amount);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
