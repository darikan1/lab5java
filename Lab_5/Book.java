import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Book {
	public int Id;
	public String Name;
	public String Author;
	public String Publisher;
	public int Year;
	public Book(int id, String name, String author, String publisher, int year) {
		this.Id = id;
		this.Name = name;
		this.Author = author;
		this.Publisher = publisher;
		this.Year = year;
		
	}
	public String getAuthor() {
		return Author;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getPublisher() {
		return Publisher;
	}
	public int getYear() {
		return Year;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public void setYear(int year) {
		Year = year;
	}
	public void preatyWrite() {
		System.out.printf("%3s| %15s| %15s| %15s| %5s|\n",this.Id, this.Name, this.Author, this.Publisher, this.Year);
	}
	
	

}
