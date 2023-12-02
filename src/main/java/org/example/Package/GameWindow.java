package org.example.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 0;
    private static final int WINDOW_POSY = 0;
    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);


        /* В основном окне GameWindow понадобится два поля, одно класса SettingsWindow
чтобы иметь возможность экземпляр этого окна показывать когда появится
необходимость и второе – это панель Map. В основном окне при создании
экземпляра окна настроек в него передаётся this.*/
        map = new Map();
        settings = new SettingsWindow(this); //Объек в качестве ссылки передает себя

        /*В аргумент метода добавления
передаётся некий новый объект класса «слушатель действия», у которого
переопределяется метод «действие произошло». Кнопка старта игры будет делать
видимым окно с будущими настройками. */
        btnExit.addActionListener(new ActionListener() { ////Добавляем слушатель действия. Кнопка старта игры будет делатьвидимым окно с будущими настройками.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() { ////Добавляем слушатель действия. Кнопка старта игры будет делатьвидимым окно с будущими настройками.
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);

    }
    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
