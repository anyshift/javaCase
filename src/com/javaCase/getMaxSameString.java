package com.javaCase;

/**
 * @author THRFUR
 * @create 2022-01-22 16:18
 */
public class getMaxSameString {
    public static void main(String[] args) {
        String str1 = "HelloJavaSE";
        String str2 = "JSE";
        String sameString = maxSameString(str1, str2);
        System.out.println(sameString);
    }

    public static String maxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                /**
                 * prefix：首
                 * suffix：尾
                 * 从整体开始，首先判断最小的字符串是不是contains在最大的字符串内。
                 * 如果不在，依次截取除首与除尾外的字符串进行contains，也就是subStr。
                 */
                for (int prefix = 0, suffix = length - i; suffix <= length; prefix++, suffix++) {
                    String subStr = minStr.substring(prefix, suffix);
                    if (maxStr.contains(subStr)) { //如果截取首尾后的的字符串在最大的字符串中
                        return subStr; //则截取后的字符串即为最大相同字符串
                    }
                }
            }
        }
        return null;
    }
}
