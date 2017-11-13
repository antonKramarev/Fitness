package fitness.service.business;

import fitness.domain.dto.ProductDTO;
import fitness.persistence.entity.ProductEntity;
import fitness.persistence.repository.ProductRepository;
import fitness.service.exeption.ResourceNotFoundException;
import fitness.service.validator.ValidationManager;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Anton_Kramarev on 6/18/2017.
 */

@Service
public class ProductBusinessService implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ValidationManager validationManager;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        validationManager.validateAndThrow(productDTO);
        ProductEntity productEntity = mapper.map(productDTO, ProductEntity.class);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return mapper.map(savedEntity, ProductDTO.class);
    }

    @Override
    public ProductDTO getProduct(Long productId) {
        return this.productRepository.findProductById(productId)
                .map(productEntity -> mapper.map(productEntity, ProductDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException(productId));
    }

    @Override
    public void deleteProduct(Long productId) {
            this.productRepository.delete(productId);
    }

    @Override
    public Page<ProductDTO> getProductByName(String name, Pageable pageable) {
        Page<ProductEntity> products = this.productRepository
                .findProductByNameStartingWith(name, pageable);
        return products.map(productEntity -> mapper.map(productEntity, ProductDTO.class));
    }


}
