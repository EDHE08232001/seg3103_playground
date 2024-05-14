import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DateNextDateOkTest {

    // Test to verify next day calculation within the same month
    @Test
    void testNextDaySimple() {
        // Simple case to increment day within the same month
        assertEquals(new Date(2020, 1, 2), new Date(2020, 1, 1).nextDate(), "Should return next day in January 2020");
    }

    // Test to verify the transition from one month to another
    @Test
    void testMonthTransition() {
        // Case for end of month transition to a new month
        assertEquals(new Date(2020, 2, 1), new Date(2020, 1, 31).nextDate(),
                "Should return first day of February 2020");
    }

    // Test to verify the transition from one year to the next
    @Test
    void testYearTransition() {
        // Case for end of year transition to a new year
        assertEquals(new Date(2021, 1, 1), new Date(2020, 12, 31).nextDate(),
                "Should return January 1st of the next year");
    }

    // Test to verify correct handling of leap years in February
    @Test
    void testLeapYearFebruary() {
        // Leap year case for February 29th
        assertEquals(new Date(2020, 2, 29), new Date(2020, 2, 28).nextDate(),
                "Should return February 29th on a leap year");
    }

    // Test to verify correct handling of non-leap year February end
    @Test
    void testNonLeapYearFebruary() {
        // Non-leap year case for end of February
        assertEquals(new Date(2021, 3, 1), new Date(2021, 2, 28).nextDate(),
                "Should return March 1st after February 28th on a non-leap year");
    }

    // Test to verify the correct transition when the next day results in a new
    // month and year
    @Test
    void testEndOfMonthYearTransition() {
        // Case for end of December transition to January of the next year
        assertEquals(new Date(2021, 1, 1), new Date(2020, 12, 31).nextDate(),
                "Should transition to January of the next year");
    }
}
