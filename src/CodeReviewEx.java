import java.util.List;

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
    /**
     * Gregorian leap-year rule: divisible by 4, except centuries,
     * unless the century is divisible by 400 (so 1900 is not, 2000 is).
     */
    public static boolean leap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
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
