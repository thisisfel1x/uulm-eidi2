package eidi2.sose25.weber.felix.sheet02.ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorCtrl implements ActionListener {

    private double currentValue = 0;
    private String currentInput = "";
    private String operator = "";
    private boolean isDecimalEntered = false;
    private boolean isNewInput = true;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();

        if (cmd.matches("[0-9]")) {
            if (isNewInput) {
                currentInput = cmd;
                isNewInput = false;
            } else {
                currentInput += cmd;
            }
            Calculator.setContent(currentInput);
        } else if (cmd.equals(".")) {
            if (!isDecimalEntered) {
                if (isNewInput || currentInput.isEmpty()) {
                    currentInput = "0.";
                } else {
                    currentInput += ".";
                }
                isDecimalEntered = true;
                isNewInput = false;
                Calculator.setContent(currentInput);
            }
        } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("x") || cmd.equals("/")) {
            compute();
            operator = cmd;
            isNewInput = true;
        } else if (cmd.equals("=")) {
            compute();
            Calculator.setContent(String.valueOf(currentValue));
            operator = "";
            isNewInput = true;
        } else if (cmd.equals("Clear")) {
            currentInput = "";
            operator = "";
            currentValue = 0;
            isDecimalEntered = false;
            isNewInput = true;
            Calculator.setContent("0");
        }

        // Ignore other buttons for now
    }

    private void compute() {
        double input = 0;
        if (!currentInput.equals("")) {
            input = Double.parseDouble(currentInput);
        }

        switch (operator) {
            case "":
                currentValue = input;
                break;
            case "+":
                currentValue += input;
                break;
            case "-":
                currentValue -= input;
                break;
            case "x":
                currentValue *= input;
                break;
            case "/":
                currentValue /= input;
                break;
        }

        currentInput = "";
        isDecimalEntered = false;
    }
}
