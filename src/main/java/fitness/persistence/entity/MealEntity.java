package fitness.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Anton_Kramarev on 7/20/2017.
 */
@Entity
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<ProductLineEntity> lines;

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

    public List<ProductLineEntity> getLines() {
        return lines;
    }

    public void setLines(List<ProductLineEntity> lines) {
        this.lines = lines;
    }
}
