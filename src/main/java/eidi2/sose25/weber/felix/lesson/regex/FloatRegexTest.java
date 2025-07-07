package eidi2.sose25.weber.felix.lesson.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FloatRegexTest {

    public static void main(String[] args) {
        String regex = "([1-9][0-9]*|0)\\.(0|[0-9]*[1-9])";
        Pattern pattern = Pattern.compile(regex);

        String[] validNumbers = {
                "0.0",
                "0.5",
                "1.0",
                "3.14",
                "10.1",
                "123.456",
                "5.123456789"
        };

        String[] invalidNumbers = {
                "00.1",
                "01.1",
                "1.10",
                "2.00",
                "0.00",
                ".5",
                "1.",
                "1.1.1",
                "abc",
                "1.1a"
        };

        System.out.println("Erkannte Zahlen:");
        for (String num : validNumbers) {
            Matcher matcher = pattern.matcher(num);
            if (matcher.matches()) {
                System.out.println(num);
            }
        }

        System.out.println("\nNicht erkannte Zahlen:");
        for (String num : invalidNumbers) {
            Matcher matcher = pattern.matcher(num);
            if (!matcher.matches()) {
                System.out.println(num);
            }
        }
    }
}

