package org.arcctg;

import java.util.Map;

public class Count {
    public static double count(Map<Object, Object> map) {
        return map.values().stream()
                .filter(value -> value instanceof Number)
                .mapToDouble(value -> ((Number) value).doubleValue())
                .sum();
    }
}
