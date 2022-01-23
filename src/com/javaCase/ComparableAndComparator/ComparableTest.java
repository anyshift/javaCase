package com.javaCase.ComparableAndComparator;

import java.util.Arrays;

/**
 * 比较器之Comparable
 * 1、像String、包装类等都实现了Comparable接口，重写了CompareTo(obj)方法。所以可以直接比较
 * 2、如果要自定义比较，则需要自己重写Comparable接口的CompareTo(obj)方法。
 * 3、compareTo(obj)的规则：
 *          如果当前对象this大于形参对象obj，则返回正整数
 *          如果当前对象this小于形参对象obj，则返回负整数
 *          如果当前对象this等于形参对象obj，则返回零
 * @author THRFUR
 * @create 2022-01-23 10:03
 */
public class ComparableTest {
    public static void main(String[] args) {
        Goods[] goods = new Goods[]{
                new Goods("Phone", 5000),
                new Goods("TV", 3500),
                new Goods("Computer", 10000)
        };
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}

class Goods implements Comparable {
    private final String goodsName;
    private final int goodsPrice;

    public Goods(String goodsName, int goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "goodsName:" + goodsName + "，goodsPrice:" + goodsPrice + "\n";
    }

    /**
     * 如果当前对象this大于形参对象obj，则返回正整数
     * 如果当前对象this小于形参对象obj，则返回负整数
     * 如果当前对象this等于形参对象obj，则返回零
     * @param o 传入的待排序类
     * @return 比较值
     */

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o; //首先需要强转类型
            /*
             * 价格比较方式一
             * if (this.goodsPrice > goods.goodsPrice) {
             *     return 1;
             * } else if (this.goodsPrice < goods.goodsPrice) {
             *     return -1;
             * } else return 0;
             */

            /*
             * 价格比较方式二，调用xxx.compare()方法
             */
            return Integer.compare(this.goodsPrice, goods.goodsPrice);


            /*
             * 商品名称比较，因为String类型重写了compareTo方法，所以可以直接调用compareTo方法
             * return this.goodsName.compareTo(goods.goodsName);
            */

        } else throw new RuntimeException("传入的类型不一致");
    }
}
