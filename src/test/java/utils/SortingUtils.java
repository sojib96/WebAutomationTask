package utils;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SortingUtils {

    public <T extends Comparable<T>> List<T> getExpectedSortedList(List<T> list, boolean reverse) {
        return list.stream()
                .sorted(reverse ? Collections.reverseOrder() : Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
