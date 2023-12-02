package org.example.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatError extends JFrame {
    private static final int WINDOW_HEIGHT = 240;
    private static final int WINDOW_WIDTH = 320;
    JButton btnOk = new JButton("Ok.");
    JLabel lblMessage;
    ChatError(String message){
        lblMessage = new JLabel(message);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ErrorWindow");
        setResizable(false);
        add(lblMessage, BorderLayout.NORTH);
        add(btnOk,BorderLayout.SOUTH);
        setVisible(true);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
