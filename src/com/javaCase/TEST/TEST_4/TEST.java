package com.javaCase.TEST.TEST_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TEST {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }
    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        List<Message> receiveds = new ArrayList<Message>(); //空Message类型的ArrayList集合
        Set<Integer> set = new TreeSet<Integer>(); //空Integer类型的TreeSet集合
        for (Message message: received) {  //把形参传来的received遍历给同样是Message类型的message
            if (!set.contains(message.sequence)) {  //如果set集合里面没有相同的sequence，则执行
                set.add(message.sequence); //将不重复的sequence(Key值)添加进set中
                receiveds.add(message); //将不重复的received添加到receiveds中
            }//如果set集合里存在相同的sequence，则不执行
        }
        return receiveds; //返回ArrayList集合
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}