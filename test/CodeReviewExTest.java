import java.util.ArrayList;
import java.util.List;

/**
 * Minimal test runner (no build tool needed). In a real project these would be
 * JUnit 5 tests run by Maven or Gradle; the idea is the same.
 * Each fix PR adds the tests that prove its Jira ticket is fixed.
 */
public class CodeReviewExTest {
    private static final List<String> failures = new ArrayList<>();
    private static int passed = 0;

    static void check(String name, Object expected, Object actual) {
        if (expected.equals(actual)) {
            passed++;
        } else {
            failures.add(name + ": expected " + expected + " but was " + actual);
        }
    }

    static boolean throwsIllegalArgument(Runnable r) {
        try {
            r.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public static void main(String[] args) {
        // Tests are added by the fix PRs below this line.

        // KAN-9: tens digit 5 was compared with the int 5, not the char '5'
        check("leap(1952)", true, CodeReviewEx.leap(1952));
        check("leap(1956)", true, CodeReviewEx.leap(1956));
        check("leap(1958)", false, CodeReviewEx.leap(1958));
        // KAN-10: centuries divisible by 400 are leap years
        check("leap(2000)", true, CodeReviewEx.leap(2000));
        check("leap(1900)", false, CodeReviewEx.leap(1900));
        check("leap(2100)", false, CodeReviewEx.leap(2100));
        // KAN-11: years with fewer than 4 digits used to throw
        check("leap(800)", true, CodeReviewEx.leap(800));
        check("leap(99)", false, CodeReviewEx.leap(99));
        // ordinary years
        check("leap(2024)", true, CodeReviewEx.leap(2024));
        check("leap(2023)", false, CodeReviewEx.leap(2023));

        // KAN-7: Sep-Nov were one day short (August counted as 30)
        check("dayOfYear(9, 1, 2025)", 244, CodeReviewEx.dayOfYear(9, 1, 2025));
        check("dayOfYear(10, 1, 2025)", 274, CodeReviewEx.dayOfYear(10, 1, 2025));
        check("dayOfYear(11, 1, 2025)", 305, CodeReviewEx.dayOfYear(11, 1, 2025));
        check("dayOfYear(12, 31, 2025)", 365, CodeReviewEx.dayOfYear(12, 31, 2025));
        // KAN-8: leap years add a day from March on
        check("dayOfYear(2, 29, 2024)", 60, CodeReviewEx.dayOfYear(2, 29, 2024));
        check("dayOfYear(3, 1, 2024)", 61, CodeReviewEx.dayOfYear(3, 1, 2024));
        check("dayOfYear(12, 31, 2024)", 366, CodeReviewEx.dayOfYear(12, 31, 2024));
        // every day of two years against java.time
        for (int year : new int[] {2023, 2024}) {
            java.time.LocalDate d = java.time.LocalDate.of(year, 1, 1);
            while (d.getYear() == year) {
                check("dayOfYear " + d, d.getDayOfYear(),
                      CodeReviewEx.dayOfYear(d.getMonthValue(), d.getDayOfMonth(), year));
                d = d.plusDays(1);
            }
        }
        // KAN-13: invalid input fails fast instead of returning a wrong number
        check("dayOfYear(13, 5, 2025) throws", true, throwsIllegalArgument(() -> CodeReviewEx.dayOfYear(13, 5, 2025)));
        check("dayOfYear(2, 29, 2025) throws", true, throwsIllegalArgument(() -> CodeReviewEx.dayOfYear(2, 29, 2025)));

        System.out.println(passed + " passed, " + failures.size() + " failed");
        failures.forEach(f -> System.out.println("FAIL " + f));
        if (!failures.isEmpty()) System.exit(1);
    }
}
