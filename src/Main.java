import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (1 > 0) {
            System.out.println("Введите выражение");
            String userInput = scanner.next();
            System.out.println(parseUserInput(userInput));
        }
    }
    public static String parseUserInput(String userInput) throws IOException {
        String expressionChar = "";
        String result = "";
        if (userInput.indexOf('*') != -1) {
            expressionChar = "\\*";
        } else if (userInput.indexOf('/') != -1) {
            expressionChar = "/";
        } else if (userInput.indexOf('-') != -1) {
            expressionChar = "-";
        } else if (userInput.indexOf('+') != -1) {
            expressionChar = "\\+";
        } else {
            throw new IOException("Вы пропустили знак или ввели некорректный");
        }
        String[] numStrArray = userInput.split(expressionChar);
        if (numStrArray.length != 2) {
            throw new IOException("Нельзя использовать больше или меньше двух аргументов");
        }
        Convertor1 convertorToRoman = new Convertor1();
        if(convertorToRoman.isRoman(numStrArray[0]) && convertorToRoman.isRoman(numStrArray[1])) {
            result = convertorToRoman.conventeRomanToArabian(numStrArray,expressionChar);
            return result;
        } else {
           return result = Integer.toString(calculateArabian(expressionChar, numStrArray));
        }
    }
    public static int calculateArabian (String expressionChar, String[] numStrArray) throws IOException {
       int a = 0;
       int b = 0;
       if (numStrArray[0].indexOf('.') > -1 || numStrArray[1].indexOf('.') > -1){
           throw new IOException("Нельзя использовать числа с плавующей точкой");
       }
        try {
            a = Integer.parseInt(numStrArray[0]);
            b = Integer.parseInt(numStrArray[1]);
        } catch (NumberFormatException e) {
            System.out.println("Введено некорректное значение аргументов");
        }
        if(a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IOException("Значение одного из операндов выходит за предел допустимых значений");
        }
        int result = 0;
        switch (expressionChar) {
            case("\\+"):
                result = a + b;
                break;
            case("-"):
                result = a - b;
                break;
            case("\\*"):
                result = a * b;
                break;
            case("/"):
                result = a / b;
                break;
        }
        return result;
    }
}