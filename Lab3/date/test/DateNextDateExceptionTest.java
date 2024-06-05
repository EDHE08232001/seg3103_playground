import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {

  private int year;
  private int month;
  private int day;

  public DateNextDateExceptionTest(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  @Parameters
  public static List<Integer[]> data() {
    List<Integer[]> params = new LinkedList<>();
    params.add(new Integer[] { 1500, 2, 30 }); // Invalid date
    params.add(new Integer[] { 1500, 2, 29 }); // Invalid date (1500 is not a leap year)
    params.add(new Integer[] { -1, 10, 20 }); // Invalid year
    params.add(new Integer[] { 1458, 15, 12 }); // Invalid month
    params.add(new Integer[] { 1975, 6, -50 }); // Invalid day
    return params;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNextDate() {
    // This will throw an IllegalArgumentException if the date is invalid
    new Date(year, month, day);
  }
}
