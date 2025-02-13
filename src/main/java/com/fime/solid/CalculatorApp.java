package com.fime.solid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField input1, input2, result;
    private JButton addButton;

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        input1 = new JTextField();
        input1.setBounds(50, 20, 80, 30);
        add(input1);

        input2 = new JTextField();
        input2.setBounds(150, 20, 80, 30);
        add(input2);

        addButton = new JButton("Add");
        addButton.setBounds(50, 60, 180, 30);
        add(addButton);

        result = new JTextField();
        result.setBounds(50, 100, 180, 30);
        result.setEditable(false);
        add(result);

        // ❌ Business logic directly inside UI event listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(input1.getText());
                    int num2 = Integer.parseInt(input2.getText());
                    int sum = num1 + num2;
                    result.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    result.setText("Invalid input");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp().setVisible(true));
    }
}
