package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoanedBook extends Book {

	private Date loanedDate;
	private Date expectedReturnDate;
	private boolean currentlyAvailable;
	private boolean late;
	
	public LoanedBook(String title, String author, String genre, String isbn, String pub, String copyrite) {
		super(title, author, genre, isbn, pub,copyrite);
		currentlyAvailable = true;
		late = false;
	}
	public LoanedBook(Book b)
	{
		super(b.getTitle(),b.getAuthor(),b.getGenre(),b.getISBN(),b.getPublisher(),b.getCopyDate());
		// Set up loan date
		Calendar calendar=Calendar.getInstance();
		loanedDate = calendar.getTime();
		calendar.setTime(loanedDate);
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();
		currentlyAvailable = false;
		late = false;
	}
	public LoanedBook(Book b, Date loanedDate, Date expectedReturnDate)
	{
		super(b.getTitle(),b.getAuthor(),b.getGenre(),b.getISBN(),b.getPublisher(),b.getCopyDate());
		this.loanedDate = loanedDate;
		this.expectedReturnDate = expectedReturnDate;
		currentlyAvailable = false;
		late = false;
	}
	public void loanCurrentBook()
	{
		// Set up loan date
		Calendar calendar=Calendar.getInstance();
		loanedDate = calendar.getTime();
		calendar.setTime(loanedDate);
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();
		currentlyAvailable = false;
		late = false;
	}
	
	
	public void returnCurrentBook()
	{
		loanedDate = null;
		expectedReturnDate = null;
		currentlyAvailable = true;
		
	}
	
	public void checkLate() 
	{
		Date today = Calendar.getInstance().getTime();
	    if(today.compareTo(expectedReturnDate) > 0) 
	    {
	         late = true;
	    } 
	    else 
	    {
	    	  late= false;
	    }
	}
	
}
