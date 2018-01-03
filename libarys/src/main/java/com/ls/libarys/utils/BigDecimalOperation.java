package com.ls.libarys.utils;

import java.math.BigDecimal;

/**

 * 类  名：BigDecimalOperation
 * 描  述: 提供精确的加减运算乘运算
 */

public class BigDecimalOperation {
    /**      * 提供精确的加法运算。
     *
     * @param d1 被加数
     * @param d2 加数
     * @return 两个参数的和
     */
    public static double add(double d1, double d2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }
    /**  提供精确的减法运算。
     *
     * @param d1 被减数
     * @param d2 减数
     * @return 两个参数的和
     */
    public static double sub(double d1, double d2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static Double mul(Double value1, Double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2).doubleValue();
    }

}
