package org.example.Package;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame { //стартовое окно, где будут задаваться настройки поля и производиться выбор режима игры

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("Выберите режим игры"); //размещаем текс в переменной gameMode
    JLabel gameField = new JLabel("Установленный размер поля:"); // Заголовок с размером поля
    JLabel winCount = new JLabel("Установленная длина:"); // Заголовок с рдлиной
    JSlider fieldSlider = new JSlider(3,10); //добавляем слайдер для выбора количество столбцов от 3 до 10
    JSlider winLengthSlider = new JSlider(3,10); //добавляем слайдер для выбора количество строк от 3 до 10
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера"); //Переключатель
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека"); //Переключатель
    ButtonGroup gameModeButtonsGroup = new ButtonGroup(); // групируем JRadioButton humanVsAi и JRadioButton humanVsHuman в ButtonGroup gameModeButtonsGroup, для того, чтобы можно было их переключать
    JPanel panBottom; //создание панели

    /*Конструктор второго окна будет принимать экземпляр игрового
окна. В первую очередь это сделано для передачи параметров игры, а во-вторых,
чтобы красиво отцентрировать его относительно основного.*/
    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(8, 1)); //Создание панели 8строк и 1 столбец
        gameModeButtonsGroup.add(humanVsAi); //групируем JRadioButton humanVsAi и JRadioButton humanVsHuman в ButtonGroup gameModeButtonsGroup
        gameModeButtonsGroup.add(humanVsHuman); //групируем JRadioButton humanVsAi и JRadioButton humanVsHuman в ButtonGroup gameModeButtonsGroup
        panBottom.add(gameMode); //добавляем на панель текс
        panBottom.add(humanVsAi); // добавляем на панель Переключатель
        panBottom.add(humanVsHuman); // добавляем на панель Переключатель
        panBottom.add(gameField); //добавляем на панель текс
        panBottom.add(fieldSlider); // Добавляем на панель слайдер выбора количество столбцов
        panBottom.add(winCount); //добавляем на панель текс
        panBottom.add(winLengthSlider); // Добавляем на панель слайдер выбора количество строк
        panBottom.add(btnStart);
        humanVsAi.setSelected(true);
        fieldSlider.addChangeListener(new ChangeListener() { //Добавляем слушетелья для радиобатонов
            @Override
            public void stateChanged(ChangeEvent e) {
                gameField.setText("Установленный размер поля: " + fieldSlider.getValue()); // меняем текстт gameField добовляя метод значение метода getValue()
            }
        });
        winLengthSlider.addChangeListener(new ChangeListener() { //Добавляем слушетелья для радиобатонов
            @Override
            public void stateChanged(ChangeEvent e) {
                winCount.setText("Установленная длина: " + winLengthSlider.getValue()); // меняем текстт gameField добовляя метод значение метода getValue()
            }
        });

        /*Обработчик кнопки старта новой игры, когда в окне настроек нажата кнопка «начать игру», обработчик
вызывает метод главного окна, а главное окно в свою очередь уже знает, что оно
разделено на панели, и вынуждает панель Map начинать
Передаём актуальные данные выбранные пользователем*/
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(humanVsAi.isSelected()?0:1,
                        fieldSlider.getValue(),
                        fieldSlider.getValue(),
                        winLengthSlider.getValue());
                setVisible(false);

            }
        });
        add(panBottom);
//        add(btnStart);

    }
}
