package com.javaCase.TEST.TEST_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TEST_2 {
    public static void main(String[] args) {
        List<Messages> received = List.of(
                new Messages(1, "Hello!"),
                new Messages(2, "发工资了吗？"),
                new Messages(2, "发工资了吗？"),
                new Messages(3, "去哪吃饭？"),
                new Messages(3, "去哪吃饭？"),
                new Messages(4, "Bye")
        );
        List<Messages> displayMessages = process(received);
        for (Messages message : displayMessages) {
            System.out.println(message.text);
        }
    }
    static List<Messages> process(List<Messages> received) {
        // TODO: 按sequence去除重复消息
        List<Messages> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>(); //因为set.add(message.sequence)参数里面是Int型
        for (Messages message: received) {
            if (set.add(message.sequence)) { //如果存在相同值是 false
                list.add(message); //将筛选后不重复的message添加到ArrayList集合中
            }
        }
        return list; //返回ArrayList集合
    }
}

class Messages {
    public final int sequence;
    public final String text;
    public Messages(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}