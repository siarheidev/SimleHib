package table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "author")
public class Author {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String last_name;
	private String first_name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name = "book_authors", 
			joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn (name = "book_id" , referencedColumnName = "id"))
	private Set <Book> books = new HashSet<Book>();
	private String middle_name;

	@Column (name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Column (name = "last_name")
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column (name = "first_name")
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Column (name = "middle_name")
	public String getMiddle_name() {
		return middle_name;
	}
	
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	

	public Set <Book> getBooks() {
		return books;
	}

	public void setBooks(Set <Book> books) {
		this.books = books;
	}

	
	

}
