package fitness.dozer;

import org.dozer.CustomConverter;

import static java.util.Objects.isNull;

/**
 * Created by toxa on 7/13/2017.
 */
public class StringEnumConverter implements CustomConverter {

    @Override
    public Object convert(Object dst, Object src, Class<?> destinationClass, Class<?> sourceClass) {
        if (isNull(src))
            return null;
        if (String.class.isAssignableFrom(sourceClass)
                && Enum.class.isAssignableFrom(destinationClass)) {
            return Enum.valueOf((Class<Enum>) destinationClass,
                    (String) src);
        }
        if (Enum.class.isAssignableFrom(sourceClass)
                && String.class.isAssignableFrom(destinationClass)) {
            return src.toString();
        }
        return null;
    }
}
