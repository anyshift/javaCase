package com.javaCase.TEST.TEST_13.SwingTest_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author THRFUR
 * @since 2022-02-07 13:21
 */
public class MyFrame extends JFrame {


    public MyFrame(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        JLabel account = new JLabel();
        account.setText("账号：");
        panel.add(account);
        JTextField act = new JTextField(15);
        act.setSize(15,10);
        panel.add(act);

        JLabel password = new JLabel();
        password.setText("密码：");
        panel.add(password);
        JTextField pwd = new JTextField(15);
        panel.add(pwd);

        JCheckBox agreePolicy = new JCheckBox();
        agreePolicy.setText("同意用户协议");
        agreePolicy.setSelected(false);
        panel.add(agreePolicy);

        JButton login = new JButton();
        login.setEnabled(false);
        login.setText("登录");
        panel.add(login);

        agreePolicy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (agreePolicy.isSelected()) {
                    login.setEnabled(true);
                } else login.setEnabled(false);
            }
        });
    }
}
