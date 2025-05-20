package eidi2.sose25.weber.felix.sheet02.ex01;

import javax.swing.*;
import java.awt.*;


public class Calculator {

    // Names of all buttons on a basic calculator
    private final static String[] BUTTON_NAMES = {"(", ")", "Undo", "Clear", "7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "0", ".", "=", "+"};

    private static JTextField output = null;

    public static void main(String[] args) {

        createGui();
    }

    private static void createGui() {
        // Button Actions Controller
        CalculatorCtrl ctrl = new CalculatorCtrl();

        // Calculator window
        JFrame frame = new JFrame("Calculator");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(480, 640));
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        // Display area
        output = new JTextField("0");
        output.setEditable(false);
        output.setFont(new Font("Arial", Font.BOLD, 32));
        output.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(output, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        for (String name : BUTTON_NAMES) {
            JButton button = new JButton(name);
            button.addActionListener(ctrl);
            button.setActionCommand(name);
            panel.add(button);
        }

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setContent(String value) {
        output.setText(value);
    }
}
