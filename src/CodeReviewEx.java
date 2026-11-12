public class CodeReviewEx {
    public static void main(String[] args) {
        System.out.println("This will be printed");
    }
    /* Q1 ~ Q8 (dayOfYear) */
    public static int dayOfYear(int month, int dayOfMonth, int year) {
        if (month == 2) {
            dayOfMonth += 31;
        } else if (month == 3) {
            dayOfMonth += 59;
        } else if (month == 4) {
            dayOfMonth += 90;
        } else if (month == 5) {
            dayOfMonth += 31 + 28 + 31 + 30;
        } else if (month == 6) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31;
        } else if (month == 7) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30;
        } else if (month == 8) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31;
        } else if (month == 9) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 30;
        } else if (month == 10) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 30 + 30;
        } else if (month == 11) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 30 + 30 + 31;
        } else if (month == 12) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 30 + 30 + 31 + 31;
        }
        return dayOfMonth;
    }
    /* Q9 ~ Q12 (leap) */
    public static boolean leap(int y) {
        String tmp = String.valueOf(y);
        if (tmp.charAt(2) == '1' || tmp.charAt(2) == '3' || tmp.charAt(2) == 5 || tmp.charAt(2) == '7' || tmp.charAt(2) == '9') {
            if (tmp.charAt(3)=='2'||tmp.charAt(3)=='6') return true; /*R1*/
            else
                return false; /*R2*/
        }else{
            if (tmp.charAt(2) == '0' && tmp.charAt(3) == '0') {
                return false; /*R3*/
            }
            if (tmp.charAt(3)=='0'||tmp.charAt(3)=='4'||tmp.charAt(3)=='8')return true; /*R4*/
        }
        return false; /*R5*/
    }
    /* Q13 ~ Q18 (countLongWords) */
    public static int LONG_WORD_LENGTH = 5;
    public static String longestWord;

    public static void countLongWords(List<String> words) {
        int n = 0;
        longestWord = "";
        for (String word: words) {
            if (word.length() > LONG_WORD_LENGTH) ++n;
            if (word.length() > longestWord.length()) longestWord = word;
        }
        System.out.println(n);
    }

}
