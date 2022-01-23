package com.javaCase.ComparableAndComparator;

import java.util.Arrays;

/**
 * �Ƚ���֮Comparable
 * 1����String����װ��ȶ�ʵ����Comparable�ӿڣ���д��CompareTo(obj)���������Կ���ֱ�ӱȽ�
 * 2�����Ҫ�Զ���Ƚϣ�����Ҫ�Լ���дComparable�ӿڵ�CompareTo(obj)������
 * 3��compareTo(obj)�Ĺ���
 *          �����ǰ����this�����βζ���obj���򷵻�������
 *          �����ǰ����thisС���βζ���obj���򷵻ظ�����
 *          �����ǰ����this�����βζ���obj���򷵻���
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
        return "goodsName:" + goodsName + "��goodsPrice:" + goodsPrice + "\n";
    }

    /**
     * �����ǰ����this�����βζ���obj���򷵻�������
     * �����ǰ����thisС���βζ���obj���򷵻ظ�����
     * �����ǰ����this�����βζ���obj���򷵻���
     * @param o ����Ĵ�������
     * @return �Ƚ�ֵ
     */

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o; //������Ҫǿת����
            /*
             * �۸�ȽϷ�ʽһ
             * if (this.goodsPrice > goods.goodsPrice) {
             *     return 1;
             * } else if (this.goodsPrice < goods.goodsPrice) {
             *     return -1;
             * } else return 0;
             */

            /*
             * �۸�ȽϷ�ʽ��������xxx.compare()����
             */
            return Integer.compare(this.goodsPrice, goods.goodsPrice);


            /*
             * ��Ʒ���ƱȽϣ���ΪString������д��compareTo���������Կ���ֱ�ӵ���compareTo����
             * return this.goodsName.compareTo(goods.goodsName);
            */

        } else throw new RuntimeException("��������Ͳ�һ��");
    }
}
