import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  // Tests the basic functionality of the nextDate method for a straightforward
  // case
  @Test
  void nextDate_sample() {
    Date d = new Date(2020, 5, 3);
    assertEquals(new Date(2020, 5, 4), d.nextDate(), "Should return the next day correctly within the same month");
  }

  // Tests the nextDate method on standard cases, ensuring it handles end of month
  // transitions
  @Test
  void testNextDateStandardCases() {
    assertAll("Testing standard date increments",
        () -> assertEquals(new Date(1700, 6, 21), new Date(1700, 6, 20).nextDate(),
            "Next day in June should be calculated correctly"),
        () -> assertEquals(new Date(2005, 4, 16), new Date(2005, 4, 15).nextDate(),
            "Next day in April should be calculated correctly"),
        () -> assertEquals(new Date(1901, 7, 21), new Date(1901, 7, 20).nextDate(),
            "Next day in July should be calculated correctly"));
  }

  // Tests the nextDate method's handling of dates around leap years, including
  // end of February calculations
  @Test
  void testNextDateLeapYear() {
    assertAll("Testing transitions related to leap years",
        () -> assertEquals(new Date(444, 3, 1), new Date(444, 2, 29).nextDate(),
            "Transition from leap day should handle leap year correctly"),
        () -> assertEquals(new Date(2001, 3, 1), new Date(2001, 2, 28).nextDate(),
            "End of February in a non-leap year should transition to March"),
        () -> assertEquals(new Date(2000, 2, 29), new Date(2000, 2, 28).nextDate(),
            "Century leap year should correctly recognize February 29th"));
  }

  // Tests the nextDate method for various scenarios where inputs are invalid and
  // exceptions are expected
  @Test
  void testNextDateInvalidInputs() {
    assertAll("Testing invalid date inputs leading to exceptions",
        () -> assertThrows(IllegalArgumentException.class,
            () -> new Date(1500, 2, 31).nextDate(),
            "Invalid day in February should throw IllegalArgumentException"),
        () -> assertThrows(IllegalArgumentException.class,
            () -> new Date(1500, 2, 29).nextDate(),
            "Non-leap year should not allow February 29 and throw IllegalArgumentException"),
        () -> assertThrows(IllegalArgumentException.class,
            () -> new Date(-1, 10, 20).nextDate(),
            "Negative year values should throw IllegalArgumentException"),
        () -> assertThrows(IllegalArgumentException.class,
            () -> new Date(1975, 6, -50).nextDate(),
            "Negative day values should throw IllegalArgumentException"));
  }
}
