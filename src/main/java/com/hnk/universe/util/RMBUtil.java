package com.hnk.universe.util;

import java.math.BigDecimal;

/**
 * @Description 人民币转大写
 * @Author naikuo
 * @Date 2020/1/17 3:41 PM
 */
public class RMBUtil {

    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] RADICES = {"", "拾", "佰", "仟"};
    private static final String[] BIG_RADICES = {"", "万", "亿", "兆"};

    private static final BigDecimal HUNDRED = new BigDecimal(1000);

    public static String toUpper(String price) {

        long money = 0;
        if (price.length() > 0) {
            BigDecimal b = new BigDecimal(price);
            money = b.multiply(HUNDRED).longValue();
        }

        StringBuilder result = new StringBuilder("");
        if (money == 0) {
            return CN_UPPER_NUMBER[0];
        }
        long integral = money / 1000;
        int integralLen = (integral + "").length();
        int decimal = (int) (money % 1000);
        if (integral > 0) {
            int zeroCount = 0;
            for (int i = 0; i < integralLen; i++) {
                int unitLen = integralLen - i - 1;
                int d = Integer.parseInt((integral + "").substring(i, i + 1));
                int quotient = unitLen / 4;
                int modulus = unitLen % 4;
                if (d == 0) {
                    zeroCount++;
                } else {
                    if (zeroCount > 0) {
                        result.append(CN_UPPER_NUMBER[0]);
                    }
                    zeroCount = 0;
                    result.append(CN_UPPER_NUMBER[d]).append(RADICES[modulus]);
                }
                if (modulus == 0 && zeroCount < 4) {
                    result.append(BIG_RADICES[quotient]);
                }
            }
            result.append("圆");
        }
        if (decimal > 0) {
            int j = decimal / 100;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("角");
            }
            j = decimal % 100 / 10;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("分");
            }
            j = decimal % 100 % 10;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("厘");
            }
        } else {
            result.append("整");
        }
        return result.toString();
    }
}