package fitness.domain.dto;

import com.google.common.base.Objects;
import fitness.domain.dto.types.*;
import fitness.service.utils.ValidationConstants;
import io.swagger.models.auth.In;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */

public class ProductDTO implements Nutrition{
    private Long id;

    @NotEmpty(message = ValidationConstants.PRODUCT_NAME_IS_EMPTY )
    @Size(max = 256, message = ValidationConstants.PRODUCT_NAME_TOO_LONG)
    private String name;
    @NotNull(message = ValidationConstants.PRODUCT_MEASURE_IS_REQUIRED)
    private Measure measure;
    @NotNull(message = ValidationConstants.TOTALS_IS_REQUIRED)
    @Valid
    private Totals totals;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Totals getTotals() {
        return totals;
    }

    public void setTotals(Totals totals) {
        this.totals = totals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
