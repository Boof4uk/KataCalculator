import java.io.IOException;

public class Convertor1 {
    String[] romanNums = {"нулевой элемент", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI","XII", "XIII",
            "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XVI", "XXV", "XXVII",
            "XXVIII", "XXX", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L",
            "LIV", "LVI", "LX", "LXIII", "LXIV", "LXXII", "LXXXI", "XC", "C"};
    public boolean isRoman(String strNum) {
        for (int i = 0; i < 11; i++) {
            if (strNum.equals(romanNums[i])) {
                return true;
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
