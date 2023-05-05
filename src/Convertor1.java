import java.io.IOException;

public class Convertor1 {
    String[] romanNums = {"Нулевоезначениее", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public boolean isRoman(String strNum) throws IOException {
        for (int i = 0; i < 101; i++) {
            if (strNum.equals(romanNums[i]) && i < 11) {
                return true;
            } else if(strNum.equals(romanNums[i]) && i >= 11) {
                throw new IOException("Римские числа можно использовать в диапазоне от I до X");
            }
        }
        return false;
    }
    public String conventeRomanToArabian(String[] userArray, String expressionChar) throws IOException {
        int arabianResult = 0;
        int[]arabianArray = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < romanNums.length; j++ ) {
                if (userArray[i].equals(romanNums[j])) {
                    arabianArray[i] = j;
                    break;
                }
            }
        }
        switch(expressionChar){
            case("\\+"):
                arabianResult = arabianArray[0] + arabianArray[1];
                break;
            case("-"):
                arabianResult = arabianArray[0] - arabianArray[1];
                if(arabianResult <= 0){
                    throw new IOException("В римской системе нет нуля и отрицательных чисел");
                }
                break;
            case("\\*"):
                arabianResult = arabianArray[0] * arabianArray[1];
                break;
            case("/"):
                arabianResult = arabianArray[0] / arabianArray[1];
                if(arabianResult <= 0) {
                    throw new IOException("Римское число не может быть меньше или равно 0");
                }
                break;
        }
        return conventArabianToRoman(arabianResult);
    }
    public String conventArabianToRoman(int arabianResult) {
        String result = romanNums[arabianResult];
        return result;
    }
}
