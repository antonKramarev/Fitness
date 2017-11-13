package fitness.domain.dto.types;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */

public class Totals {

    private static final int MAX_PROTEIN_VALUE = 1000;
    private static final int MIN_NUTRIENT_VALUE = 0;
    private static final int MAX_CALORIES_VALUE = 100000;
    private static final int MAX_CARBOHYDRATE_VALUE = 1000;
    private static final int MAX_FAT_VALUE = 1000;

    @NotNull
    @Max(MAX_PROTEIN_VALUE)
    @Min(MIN_NUTRIENT_VALUE)
    private Integer protein;

    @NotNull
    @Max(MAX_FAT_VALUE)
    @Min(MIN_NUTRIENT_VALUE)
    private Integer fat;

    @NotNull
    @Max(MAX_CARBOHYDRATE_VALUE)
    @Min(MIN_NUTRIENT_VALUE)
    private Integer carbohydrate;

    @NotNull
    @Max(MAX_CALORIES_VALUE)
    @Min(MIN_NUTRIENT_VALUE)
    private Integer calories;

    public Totals(Integer protein, Integer fat, Integer carbohydrate, Integer calories) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.calories = calories;
    }

    public Totals() {
    }

    public static Totals sum(Totals a, Totals b) {
        return Totals.of(a.protein + b.protein,
                a.fat + b.fat,
                a.carbohydrate + b.carbohydrate,
                a.calories + b.calories);
    }

    public static Totals empty() {
        return Totals.of(0, 0, 0, 0);
    }

    public static Totals of(Integer protein, Integer fat, Integer carbohydrate, Integer calories) {
        return new Totals(protein, fat, carbohydrate, calories);
    }
    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Integer carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
