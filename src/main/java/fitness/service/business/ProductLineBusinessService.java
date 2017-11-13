package fitness.service.business;

import fitness.domain.dto.ProductLineDTO;
import fitness.persistence.entity.ProductLineEntity;
import fitness.persistence.repository.ProductLineRepository;
import fitness.service.exeption.ResourceNotFoundException;
import fitness.service.validator.ValidationManager;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by toxa on 7/19/2017.
 */
@Service
public class ProductLineBusinessService implements ProductLineService {

    @Autowired
    private ProductLineRepository lineRepository;
    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private ValidationManager validationManager;

    @Override
    public ProductLineDTO createProductLine(ProductLineDTO lineDTO) {
        validationManager.validateAndThrow(lineDTO);
        ProductLineEntity lineEntity = mapper.map(lineDTO, ProductLineEntity.class);
        ProductLineEntity savedLine = lineRepository.save(lineEntity);
        return mapper.map(savedLine, ProductLineDTO.class);
    }

    @Override
    public void deleteProductLine(Long lineId) {
        this.lineRepository.delete(lineId);
    }

    @Override
    public ProductLineDTO getProductLine(Long id) {
        return this.lineRepository.findProductLineById(id)
                .map(productLineEntity -> mapper.map(productLineEntity, ProductLineDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
