package fitness.domain.dto.types;

import java.util.function.BiFunction;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
public enum Measure implements BiFunction<Integer, Integer, Integer> {

    COUNT {
        @Override
        public Integer apply(Integer productValue, Integer value) {
            return productValue * value;
        }
    }, WEIGHT {
        @Override
        public Integer apply(Integer productValue, Integer lineValue) {
            return productValue * lineValue / MEASURE_VALUE_IN_GRAMS;
        }
    };
    public static final int MEASURE_VALUE_IN_GRAMS = 100;

}
