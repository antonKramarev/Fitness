package fitness.rest.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.Objects;

/**
 * Created by Anton_Kramarev on 6/26/2017.
 */
public class ProductLineModel extends ResourceSupport {
    private Integer value;
    private Long productId;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductLineModel that = (ProductLineModel) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, productId);
    }
}
