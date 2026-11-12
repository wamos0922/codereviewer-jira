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
        // ordinary years
        check("leap(2024)", true, CodeReviewEx.leap(2024));
        check("leap(2023)", false, CodeReviewEx.leap(2023));

        System.out.println(passed + " passed, " + failures.size() + " failed");
        failures.forEach(f -> System.out.println("FAIL " + f));
        if (!failures.isEmpty()) System.exit(1);
    }
}
