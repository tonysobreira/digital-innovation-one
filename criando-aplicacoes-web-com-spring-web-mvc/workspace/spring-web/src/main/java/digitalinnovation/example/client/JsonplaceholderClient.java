package digitalinnovation.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import digitalinnovation.example.dto.Todo;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "jsonplaceholder")
public interface JsonplaceholderClient {

	@GetMapping("/todos")
	List<Todo> findTodos();
	
	@GetMapping("/todos")
	String findTodosString();

}
