package fitness.domain.dto;

import fitness.domain.dto.types.*;
import fitness.domain.utils.ProductLineOperation;
import fitness.domain.utils.ProductLineOperations;
import fitness.service.utils.ValidationConstants;

import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ProductLineDTO implements Nutrition {

    private Long id;
    @NotNull
    private ProductDTO product;
    @NotNull(message = ValidationConstants.PRODUCT_LINE_VALUE_REQUIRED)
    private Integer value;

    public ProductLineDTO(Long id, ProductDTO product, Integer value) {
        this.id = id;
        this.product = product;
        this.value = value;
    }

    public ProductLineDTO() {
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public Integer getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Totals getTotals() {
        return Totals.of(product.getMeasure().apply(product.getTotals().getProtein(), value),
                product.getMeasure().apply(product.getTotals().getFat(), value),
                product.getMeasure().apply(product.getTotals().getCarbohydrate(), value),
                product.getMeasure().apply(product.getTotals().getCalories(), value)
                );
    }
}
