package org.arcctg;

import java.util.List;
import java.util.stream.Stream;

public class Ip {
    public static List<Integer> parseIP(String ip) {
        List<String> list = Stream.of(ip.split("\\.")).toList();

        return list.size() == 4 && list.stream().allMatch(s -> !s.isEmpty() && s.matches("\\d+")) ?
                list.stream().map(Integer::parseInt).toList() :
                null;
    }
}
