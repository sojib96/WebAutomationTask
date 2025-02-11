package utils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DataUtils {

    public List<Double> convertPricesToDouble(List<String> priceTexts) {
        return priceTexts.stream()
                .map(text -> Double.parseDouble(text.replace("$", "")))
                .collect(Collectors.toList());
    }
}
