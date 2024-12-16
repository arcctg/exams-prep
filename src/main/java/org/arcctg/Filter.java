package org.arcctg;

import java.util.List;

public class Filter {
    public static List<Object> filter(List<Object> list, String type) {
        return list.stream()
                .filter(obj -> type.equalsIgnoreCase(obj.getClass().getSimpleName()))
                .toList();
    }
}
