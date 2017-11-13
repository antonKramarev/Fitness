package fitness.service.business;

import fitness.domain.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Anton_Kramarev on 6/18/2017.
 */
public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProduct(Long productId);

    void deleteProduct(Long productId);

    Page<ProductDTO> getProductByName(String name, Pageable pageable);

}
