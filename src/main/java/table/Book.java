package table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "book")
public class Book {

	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	@Column (name = "title")
	private String title;

	@Column (name = "isbn")
	private int isbn;

	@Column (name = "description")
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private Set <Author> authors = new HashSet<Author>();

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Set <Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set <Author> authors) {
		this.authors = authors;
	}
	
	
	

}
