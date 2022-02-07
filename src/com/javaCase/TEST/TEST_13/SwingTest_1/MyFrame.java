package com.javaCase.TEST.TEST_13.SwingTest_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author THRFUR
 * @since 2022-02-07 11:40
 */
public class MyFrame extends JFrame {
    JLabel labelTime = new JLabel();

    public MyFrame(String title){
        super(title);

        //添加一个面板panel
        JPanel panel = new JPanel();
        //将panel面板设置为MyFrame的内容窗格
        this.setContentPane(panel);
        //往面板添加JLabel，也就是添加文本
        panel.add(labelTime);

        //新建一个按钮
        JButton button = new JButton("测试");
        //将按钮添加到面板panel中
        panel.add(button);

        //给按钮添加行动监听
        button.addActionListener(new MyActionListener());
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            //设置JLabel的内容
            labelTime.setText(sdf.format(new Date()));
        }
    }
}
