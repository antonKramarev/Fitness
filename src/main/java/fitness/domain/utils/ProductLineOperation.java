package fitness.domain.utils;

import fitness.domain.dto.ProductLineDTO;

import java.util.function.Function;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public interface ProductLineOperation extends Function<ProductLineDTO, ProductLineDTO> {
}
