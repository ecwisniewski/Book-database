package finalproject;

public class Book implements java.io.Serializable {

	protected String title;
	protected String author;
	protected String copyrite;
	protected String genre;
	protected String isbn; 
	protected String publisher;
	protected static final long serialVersionUID=1567998952404037097L;
	
	// New Book object
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
	
	// Override equals https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Book or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Book)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Book b = (Book) o; 
          
        // Compare the data members and return accordingly 
        return (this.title.toLowerCase().equals(b.title.toLowerCase()))&& (this.author.toLowerCase().equals(b.author.toLowerCase())) 
        		&& (this.genre.toLowerCase().equals(b.genre.toLowerCase()))
                && (this.publisher.toLowerCase().equals(b.publisher.toLowerCase())) &&(this.isbn.toLowerCase().equals(b.isbn.toLowerCase())) 
                &&(this.copyrite.toLowerCase().equals(b.copyrite.toLowerCase()));
                
    } 
	
	@Override
	public String toString() {
		return "Book: " + title + " by " + author;
		
	}
} 


