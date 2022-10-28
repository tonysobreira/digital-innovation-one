package one.digitalinnovation.experts.shoppingcart.model;

//import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@RedisHash("cart")
@Entity
public class Cart {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Item> items = new ArrayList<Item>();

	public Cart() {
	}

	public Cart(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}