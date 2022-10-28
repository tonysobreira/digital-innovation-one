package one.digitalinnovation.experts.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.experts.shoppingcart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

//	Cart findByCustomerId(Integer customerId);

}