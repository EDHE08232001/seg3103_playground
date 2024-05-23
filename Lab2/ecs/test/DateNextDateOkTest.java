import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DateNextDateTests {

        // Method providing data for valid scenarios
        static Stream<Arguments> validDateProvider() {
                return Stream.of(
                                Arguments.of(new Date(2020, 5, 3), new Date(2020, 5, 4),
                                                "Should return the next day correctly within the same month"),
                                Arguments.of(new Date(1700, 6, 20), new Date(1700, 6, 21),
                                                "Next day in June should be calculated correctly"),
                                Arguments.of(new Date(2005, 4, 15), new Date(2005, 4, 16),
                                                "Next day in April should be calculated correctly"),
                                Arguments.of(new Date(2020, 2, 28), new Date(2020, 2, 29),
                                                "Should handle leap day correctly for leap year"),
                                Arguments.of(new Date(2021, 2, 28), new Date(2021, 3, 1),
                                                "Should transition to March 1st after February 28th in a non-leap year"),
                                Arguments.of(new Date(2020, 12, 31), new Date(2021, 1, 1),
                                                "Should handle the transition from December to January in the next year"),
                                Arguments.of(new Date(2000, 2, 29), new Date(2000, 3, 1),
                                                "Should handle the transition from leap day February 29 to March 1st in a leap year"),
                                Arguments.of(new Date(2020, 4, 30), new Date(2020, 5, 1),
                                                "Should handle the end of April transitioning to May"));
        }

        @ParameterizedTest
        @MethodSource("validDateProvider")
        void testValidDates(Date inputDate, Date expectedDate, String message) {
                assertEquals(expectedDate, inputDate.nextDate(), message);
        }
}
