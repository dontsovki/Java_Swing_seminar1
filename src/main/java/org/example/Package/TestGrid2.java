package org.example.Package;

import javax.swing.*;
import java.awt.*;

public class TestGrid2 extends JFrame {
    public TestGrid2() {
        super("GridBagStart");
        // выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // устанавливаем расположение компонентов
        setLayout(new GridBagLayout());
        // добавляем две кнопки, ячейки по умолчанию
        add(new JButton("Привет"));
        add(new JButton("Отмена"));
        // настройка ячейки для текстового поля
        GridBagConstraints textFieldConstraints =
                new GridBagConstraints();
        // заполнение ячейки по горизонтали
        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        // просим занять все оставшиеся ячейки
        textFieldConstraints.gridwidth =
                GridBagConstraints.REMAINDER;
        textFieldConstraints.weightx = 5.0f;
        add(new JTextField(50), textFieldConstraints);
        // выведем окно на экран
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new TestGrid2();
                    }
                });
    }
}
