package finalproject;

import java.util.ArrayList;

public class BookDatabase implements java.io.Serializable {

	private ArrayList<Book> database;
	private static final long serialVersionUID = 6751649745541556469L;
	private String fileLocation;
	
	public BookDatabase()
	{
		database = new ArrayList<Book>();
		
	}
	public BookDatabase(String fileLocation)
	{
		database = new ArrayList<Book>();
		this.fileLocation=fileLocation;
	}
	public void add(Book book)
	{
		System.out.print("Addition: "+book);
		database.add(book);
		System.out.print(database.size());
	}
	public Book get(int i)
	{
		return database.get(i);
	}
	public int getSize()
	{
		return database.size();
	}
	public boolean compare(Book book) {
		// Will check equals method
		return database.contains(book);
	}
	public void delete(Book book) {
		database.remove(book);
	}
	public void readFromText()
	{
		System.out.println(database.size());
		for(int i = 0; i < database.size(); i++)
		{
			System.out.print(database.get(i));
		}
		System.out.println();
	}
	public void saveToText() {
		
	}
	
}

