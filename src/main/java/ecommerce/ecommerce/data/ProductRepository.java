package ecommerce.ecommerce.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select c from Product c " +
            "where lower(c.title) like lower(concat('%', :searchTerm, '%')) ")
    List<Product> search(@Param("searchTerm")String title);
}
