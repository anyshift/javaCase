package com.javaCase.TEST.TEST_4;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TEST {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "����������"),
                new Message(2, "����������"),
                new Message(3, "ȥ�ĳԷ���"),
                new Message(3, "ȥ�ĳԷ���"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }
    static List<Message> process(List<Message> received) {
        // TODO: ��sequenceȥ���ظ���Ϣ

        return received;
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