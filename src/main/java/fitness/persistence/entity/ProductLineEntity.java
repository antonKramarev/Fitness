package fitness.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
@Entity(name = "product_line")
public class ProductLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ProductEntity product;
    @NotNull
    private Integer value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
