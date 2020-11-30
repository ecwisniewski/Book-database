package finalproject;

import java.io.File;
import java.util.ArrayList;

public class PersonDatabase  implements java.io.Serializable {

	public static ArrayList<Person> database;
	File fileLocation;
	public PersonDatabase()
	{
		database = new ArrayList<Person>();
	}
	public void add(Person p)
	{
		database.add(p);
	}
	public Person get(int i)
	{
		return database.get(i);
	}
	public int getSize()
	{
		return database.size();
	}
	public boolean compare(Person p) {
		// Will check equals method
		return database.contains(p);
	}
	public void delete(Person p) {
		database.remove(p);
	}
	public void setFileLocation(File fileLocation) {
		this.fileLocation = fileLocation;
	}
	public File getFileLocation() {
		return fileLocation;
	}
	public Person findPerson(String name) {
		Person found=null;
		Person test;
		for(int i =0; i<database.size(); i++) {
			test = database.get(i);
			if(test.getName().equals(name)) {
				found = test;
				break;
			}
		}
		return found;
	}
}
