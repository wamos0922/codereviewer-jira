import java.util.List;

public class CodeReviewEx {
    public static void main(String[] args) {
        System.out.println("This will be printed");
    }
    /* Q1 ~ Q8 (dayOfYear) */
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Returns the day of the year (1-366) for the given date.
     *
     * @throws IllegalArgumentException if month or dayOfMonth is out of range
     */
    public static int dayOfYear(final int month, final int dayOfMonth, final int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month must be 1-12, was " + month);
        }
        int monthLength = DAYS_IN_MONTH[month - 1] + (month == 2 && leap(year) ? 1 : 0);
        if (dayOfMonth < 1 || dayOfMonth > monthLength) {
            throw new IllegalArgumentException("day must be 1-" + monthLength + ", was " + dayOfMonth);
        }
        int day = dayOfMonth;
        for (int m = 0; m < month - 1; m++) {
            day += DAYS_IN_MONTH[m];
        }
        if (month > 2 && leap(year)) {
            day++;
        }
        return day;
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
