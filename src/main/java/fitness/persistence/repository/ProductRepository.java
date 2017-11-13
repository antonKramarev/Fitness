package fitness.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import fitness.persistence.entity.ProductEntity;

import java.util.Optional;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findProductById(Long id);

    Page<ProductEntity> findProductByNameStartingWith(String name, Pageable pageable);
}
