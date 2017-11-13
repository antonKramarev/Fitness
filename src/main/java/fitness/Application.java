package fitness;

import fitness.domain.dto.types.*;
import fitness.persistence.entity.ProductEntity;
import fitness.persistence.entity.ProductLineEntity;
import fitness.persistence.repository.ProductLineRepository;
import fitness.persistence.repository.ProductRepository;
import fitness.persistence.repository.spring.ExtendedJpaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = ExtendedJpaRepository.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "dozerMapper")
    public DozerBeanMapper dozerMapper() {
        return new DozerBeanMapper(asList("dozer/product-mappings.xml"));
    }

    @Bean
    public CommandLineRunner productDemo(ProductRepository productRepository, ProductLineRepository productLineRepository) {
        return args -> {
            ProductEntity product = productRepository.save(initProduct());
            productLineRepository.save(initProductLine(product));

        };
    }

    private ProductLineEntity initProductLine(ProductEntity product) {
        ProductLineEntity lineEntity = new ProductLineEntity();
        lineEntity.setProduct(product);
        lineEntity.setValue(150);
        return lineEntity;
    }

    private ProductEntity initProduct() {
        ProductEntity product = new ProductEntity();
        product.setName("Test product");
        product.setMeasure(Measure.WEIGHT);
        product.setCalories(100);
        product.setFat(3);
        product.setProtein(20);
        product.setCarbohydrate(4);
        return product;
    }


}