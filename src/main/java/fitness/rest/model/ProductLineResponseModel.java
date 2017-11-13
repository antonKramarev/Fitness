package fitness.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Anton_Kramarev on 6/26/2017.
 */
@JsonPropertyOrder({"id", "productName"})
public class ProductLineResponseModel extends ResourceSupport {
    private Long lineId;
    private Integer value;
    private String productName;
    private TotalsModel totals;

    @JsonProperty(value = "id")
    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public TotalsModel getTotals() {
        return totals;
    }

    public void setTotals(TotalsModel totals) {
        this.totals = totals;
    }

}
