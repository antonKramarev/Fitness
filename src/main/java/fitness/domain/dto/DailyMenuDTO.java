package fitness.domain.dto;

import com.google.common.collect.Lists;
import fitness.domain.dto.types.Nutrition;
import fitness.domain.dto.types.NutritionItems;
import fitness.domain.dto.types.Totals;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by toxa on 7/29/2017.
 */
public class DailyMenuDTO implements Nutrition {

    private Long id;
    private LocalDate date = LocalDate.now();
    private List<MealDTO> meals = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public NutritionItems<MealDTO> getMeals() {
        return new NutritionItems<>(meals);
    }

    public void setMeals(NutritionItems<MealDTO> meals) {
        this.meals = meals;
    }

    public Totals getTotals() {
        return getMeals().getTotals();
    }

}
