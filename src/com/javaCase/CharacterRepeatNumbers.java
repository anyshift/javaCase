package com.javaCase;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取文本上每个字符出现的次数，字符及出现的次数保存在Map中，将Map中的数据写入到文件。
 * @author THRFUR
 * @since 2022-01-27 11:27
 */
public class CharacterRepeatNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\FileTest\\FileTest.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\FileTest\\WordsCount.txt")));

        try {
            //key为出现的字符，value为出现的次数
            Map<Character, Integer> map = new HashMap<>();

            int c = 0;
            while ((c = br.read()) != -1) {
                char ch = (char) c;  //c是从文件中读到的字符的int值，需转换为char型字符
                if (map.containsKey(ch)) { //如果读到的字符存在于map中
                    map.put(ch, map.get(ch) + 1); //根据读到的字符映射到map中，map.get(ch)得到的value值加1，记录字符的重复出现次数
                } else { //读到的字符不存在于map中
                    map.put(ch, 1); //根据读到的字符映射到map中，同时Integer赋值为1，代表第一次出现
                }
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                switch (entry.getKey()) {
                    case '\n':
                        bw.write("换行符 = " + entry.getValue()); break;
                    case ' ':
                        bw.write("空格符 = " + entry.getValue()); break;
                    case '\r':
                        bw.write("回车符 = " + entry.getValue()); break;
                    case '\t':
                        bw.write("制表符 = " + entry.getValue()); break;
                    default:
                        bw.write(entry.getKey() + " = " + entry.getValue()); break;
                }
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
