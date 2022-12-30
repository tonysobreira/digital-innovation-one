package br.com.globallabs.springwebmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jedi")
public class Jedi {

	@Id
	@Column(name = "id_jedi")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
	@Column(name = "name")
	private String name;

	@Size(max = 20, message = "Last Name must not have more than 20 letters")
	@Column(name = "last_name")
	private String lastName;

	public Jedi() {
	}

	public Jedi(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
