package digitalinnovation.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import digitalinnovation.example.client.JsonplaceholderClient;
import digitalinnovation.example.dto.Todo;

@RestController
@RequestMapping("/v1/jsonplaceholder")
public class JsonplaceholderController {

	private JsonplaceholderClient jsonplaceholderClient;

	private ObjectMapper objectMapper;

	public JsonplaceholderController(JsonplaceholderClient jsonplaceholderClient, ObjectMapper objectMapper) {
		this.jsonplaceholderClient = jsonplaceholderClient;
		this.objectMapper = objectMapper;
	}

	@GetMapping
	public ResponseEntity<List<Todo>> buscarAtualizacao() {
		
		//String to object list
		String todos = jsonplaceholderClient.findTodosString();
		try {
			List<Todo> list = new ArrayList<Todo>();
			list = Arrays.asList(objectMapper.readValue(todos, Todo[].class));
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Todo> listTodo = jsonplaceholderClient.findTodos();
		return ResponseEntity.ok(listTodo);
	}

}