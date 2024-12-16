package org.arcctg;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {
    @ParameterizedTest
    @MethodSource("testCases")
    void testCount(Map<Object, Object> input, double expected) {
        assertEquals(expected, Count.count(input),
                "Sum of numeric values did not match expected result");
    }

    private static Stream<Object[]> testCases() {
        return Stream.of(
                new Object[]{Map.of("a", 1, "b", "two", "c", 3, "d", 4), 8.0},
                new Object[]{Map.of("a", 1, "b", "two", "c", -3, "d", 4), 2.0},
                new Object[]{Map.of("a", 0, "b", "two", "c", 0, "d", -1), -1.0},
                new Object[]{Map.of("a", -1, "b", "two", "c", -3, "d", -4), -8.0},
                new Object[]{Map.of("a", 1, "b", "two", "c", -1, "d", 0), 0.0},
                new Object[]{Map.of("a", "1", "b", "two", "c", 3.6, "d", 4), 7.6}
        );
    }
}