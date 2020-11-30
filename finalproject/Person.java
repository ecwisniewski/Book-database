package finalproject;

import java.util.ArrayList;

public class Person  implements java.io.Serializable {

	private ArrayList<UsefulBook> lentBooks;
	private String name;
	public Person(String name)
	{
		this.name = name;
		lentBooks = new ArrayList<UsefulBook>();
	}
	public String getName()
	{
		return name;
	}
	public void lendBook(UsefulBook book)
	{
		System.out.println("Lend book: " + book.toString());
		lentBooks.add(book);
	}
	public void returnBook(UsefulBook book)
	{
		lentBooks.remove(book);
	}
	public boolean hasBook(UsefulBook book)
	{
		return lentBooks.contains(book);
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
        if (!(o instanceof Person)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Person p = (Person) o; 
          
        // Compare the data members and return accordingly 
        return (this.name.toLowerCase().equals(p.name.toLowerCase()));
	}
	public String toString()
	{
		String info = name + " has " + lentBooks.size() + "books:";
		for(int i = 0; i<lentBooks.size(); i++)
		{
			info += "\n"+ lentBooks.get(i).toString();
		}
		return info;
				
	}
}
