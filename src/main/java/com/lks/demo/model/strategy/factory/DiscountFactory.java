package com.lks.demo.model.strategy.factory;

import com.lks.demo.model.strategy.DiscountType;
import com.lks.demo.model.strategy.base.Discount;
import com.lks.demo.model.strategy.type.OrdinaryMember;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likesheng
 * @Time 2019/11/8
 **/
public class DiscountFactory {

    private static DiscountFactory factory;

    public DiscountFactory() {
    }

    private static Map<Integer, Discount> discountMap = new HashMap<>();

    static {
        discountMap.put(DiscountType.COMMON.getCode(),new OrdinaryMember());
        discountMap.put(DiscountType.BRONZE.getCode(),new OrdinaryMember());
        discountMap.put(DiscountType.SILVER.getCode(),new OrdinaryMember());
    }

    /**
     * 创建相应的类型
     *
     * @param type
     * @return
     */
    public static Discount create(Integer type){
        return discountMap.get(type);
    }

    /**
     * 創建對應的方法和方法(懒加载)
     *
     * @return
     */
    public static synchronized DiscountFactory getInstance(){
        if(factory==null){
            factory = new DiscountFactory();
        }
        return factory;
    }
}
