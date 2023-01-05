package digitalinnovation.example.dto;

public class Todo {

	private Long userId;

	private Long id;

	private String title;

	private Boolean completed;

	public Todo() {

	}

	public Todo(Long userId, Long id, String title, Boolean completed, Boolean completedd) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
