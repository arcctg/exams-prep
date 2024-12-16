package org.arcctg;

import org.arcctg.refactor.Ip;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class IpTest {
    @ParameterizedTest
    @MethodSource("testCases")
    void testParseIP(String input, List<Integer> expected) {
        assertEquals(expected, Ip.parseIP(input));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("127.0.0.1", List.of(127, 0, 0, 1)),
                Arguments.of("0.0.0.0", List.of(0, 0, 0, 0)),
                Arguments.of("255.255.255.0", List.of(255, 255, 255, 0)),
                Arguments.of("10.0.0.10", List.of(10, 0, 0, 10)),
                Arguments.of(".0.0.", null),
                Arguments.of("127001", null),
                Arguments.of("127.0.0", null),
                Arguments.of("", null)
        );
    }
}