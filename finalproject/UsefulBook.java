package finalproject;

public class UsefulBook extends Book implements java.io.Serializable {
	private boolean read;
	private boolean onLoan;
	private Person receipient;
	private static final long serialVersionUID = 4634369136892432987L;
	
	
	public UsefulBook(String title, String author, String genre, String isbn, String pub, String copyrite)
	{
		super(title,author,genre, isbn, pub,copyrite);
		read = false;
		onLoan = false;
	}
	public UsefulBook(Book b)
	{
		super(b.title,b.author,b.genre, b.isbn, b.publisher,b.copyrite);
	}
	
	public void readBook() {
		read = true;
		FinalProject.ReadBookDatabase.add(this);
	}
	public void loanBook(Person p) {
		System.out.println("Loan book");
		onLoan = true;
		receipient = p;
		p.lendBook(this);
	}
	public void returnBook(Person p) {
		if(p.hasBook(this)) {
			p.returnBook(this);
		}
		else
		{
			System.out.print(p.getName() + " did not have this book");
		}
	}
	public boolean isOnLoan()
	{
		return onLoan;
	}
	public Person getPerson()
	{
		return receipient;
	}
	@Override
	public boolean equals(Object o)
	{
		// If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Book or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof UsefulBook)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        UsefulBook b = (UsefulBook) o; 
          
        // Compare the data members and return accordingly 
        return (super.title.toLowerCase().equals(b.title.toLowerCase()))&& (this.author.toLowerCase().equals(b.author.toLowerCase())) 
        		&& (this.genre.toLowerCase().equals(b.genre.toLowerCase()))
                && (this.publisher.toLowerCase().equals(b.publisher.toLowerCase())) &&(this.isbn.toLowerCase().equals(b.isbn.toLowerCase())) 
                &&(this.copyrite.toLowerCase().equals(b.copyrite.toLowerCase()));
	}
	public String toString()
	{
		return super.toString();
	}

}
