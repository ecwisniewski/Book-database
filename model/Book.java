package model;

public class Book {

	private String title;
	private String author;
	private String copyrite;
	private String genre;
	private String isbn; 
	private String publisher;
	
	public Book(String title, String author, String genre, String isbn, String pub, String copyrite)
	{
		this.title = title;
		this.author=author;
		this.genre = genre;
		this.isbn = isbn;
		this.publisher = pub;
		this.copyrite = copyrite;
	}
	public String getTitle() { return title;}
	public String getAuthor() { return author;}
	public String getCopyDate() { return copyrite;}
	public String getGenre() { return genre;}
	public String getISBN() { return isbn; }
	public String getPublisher() {return publisher;}
}
