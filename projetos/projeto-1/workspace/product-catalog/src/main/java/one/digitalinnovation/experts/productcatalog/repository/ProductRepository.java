package one.digitalinnovation.experts.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.experts.productcatalog.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);

}
