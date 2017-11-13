package fitness.domain.dto;

import com.google.common.collect.Lists;
import fitness.domain.dto.types.Nutrition;
import fitness.domain.dto.types.NutritionItems;
import fitness.domain.dto.types.Totals;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by Anton_Kramarev on 7/20/2017.
 */
public class MealDTO implements Nutrition{


    private Long id;
    @NotEmpty
    private String name;

    private List<ProductLineDTO> lines = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionItems<ProductLineDTO> getLines() {
        return new NutritionItems<>(lines);
    }

    public void setLines(List<ProductLineDTO> lines) {
        this.lines = lines;
    }

    @Override
    public Totals getTotals() {
        return getLines().getTotals();
    }
}
