package fitness.domain.utils;

import fitness.domain.dto.ProductLineDTO;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public enum ProductLineOperations implements ProductLineOperation {

    UPDATE_TOTALS {
        @Override
        public ProductLineDTO apply(ProductLineDTO productLineDTO) {
            return null;
            //return ProductHelper.updateTotals(productLineDTO);
        }
    };
}
