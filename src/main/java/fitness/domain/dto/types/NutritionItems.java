package fitness.domain.dto.types;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by toxa on 7/29/2017.
 */
public class NutritionItems<T extends Nutrition> extends ForwardingList<T> {

    private List<T> delegate = Lists.newArrayList();

    @Override
    protected List<T> delegate() {
        return delegate;
    }

    public Totals getTotals() {
        return delegate.stream().map(T::getTotals).reduce(Totals::sum).orElse(Totals.empty());
    }

    public void addItem(T item) {
        if (Objects.nonNull(item)) {
            delegate.add(item);
        }
    }

    public NutritionItems (List<T> delegate){
        this.delegate = delegate;
    }
}
