package com.javaCase.TEST.TEST_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TEST_2 {
    public static void main(String[] args) {
        List<Messages> received = List.of(
                new Messages(1, "Hello!"),
                new Messages(2, "����������"),
                new Messages(2, "����������"),
                new Messages(3, "ȥ�ĳԷ���"),
                new Messages(3, "ȥ�ĳԷ���"),
                new Messages(4, "Bye")
        );
        List<Messages> displayMessages = process(received);
        for (Messages message : displayMessages) {
            System.out.println(message.text);
        }
    }
    static List<Messages> process(List<Messages> received) {
        // TODO: ��sequenceȥ���ظ���Ϣ
        List<Messages> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>(); //��Ϊset.add(message.sequence)����������Int��
        for (Messages message: received) {
            if (set.add(message.sequence)) { //���������ֵͬ�� false
                list.add(message); //��ɸѡ���ظ���message��ӵ�ArrayList������
            }
        }
        return list; //����ArrayList����
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