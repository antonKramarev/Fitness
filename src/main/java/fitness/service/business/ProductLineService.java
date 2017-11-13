package fitness.service.business;

import fitness.domain.dto.ProductLineDTO;

/**
 * Created by Anton_Kramarev on 6/18/2017.
 */
public interface ProductLineService {

    ProductLineDTO createProductLine(ProductLineDTO lineDTO);

    void deleteProductLine(Long lineId);

    ProductLineDTO getProductLine(Long lineId);
}
