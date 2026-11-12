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

        System.out.println(passed + " passed, " + failures.size() + " failed");
        failures.forEach(f -> System.out.println("FAIL " + f));
        if (!failures.isEmpty()) System.exit(1);
    }
}
