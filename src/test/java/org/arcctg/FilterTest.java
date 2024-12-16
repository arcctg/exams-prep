package org.arcctg;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFilterByType(List<Object> input, String type, List<Object> expected) {
        List<Object> result = Filter.filter(input, type);
        assertEquals(expected, result, "Filtered result did not match the expected output.");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, "three", 4, 5, "six"), "integer", List.of(1, 2, 4, 5)),
                Arguments.of(List.of(-1, 0, 1, 2), "integer", List.of(-1, 0, 1, 2)),
                Arguments.of(List.of(-1, 0, 1, 2), "string", List.of()),
                Arguments.of(List.of(true, true, false, 1, "six"), "boolean", List.of(true, true, false)),
                Arguments.of(List.of(), "string", List.of())
        );
    }
}