package com.myjava.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class CustomFlatMap {
    public static <T, R> List<R> flatMap(List<T> list, Function<T, Stream<R>> mapper) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            Stream<R> mappedStream = mapper.apply(element);
            mappedStream.forEach(result::add);
        }
        return result;
    }
}
