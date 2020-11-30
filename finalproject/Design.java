package finalproject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;



public class Design {

	public static void viewDatabasePage(JFrame old) {
		
		old.setVisible(false);
		JFrame frame = new JFrame("Book Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        // Add Menu
     	addMenuBar(frame);
     	// Initialize Columns and data
		String[] columnNames = {"Title","Author" };
		String[][] data = new String[FinalProject.MainBookDatabase.getSize()][2];
		
		// Add Data
		for(int i =0; i<FinalProject.MainBookDatabase.getSize(); i++) {
			data[i][0]=FinalProject.MainBookDatabase.get(i).getTitle();
			data[i][1]=FinalProject.MainBookDatabase.get(i).getAuthor();
		}
		
		// Create my table
		JTable tableArea = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane(tableArea);
		

        WindowClosingAction(frame);
		
		// Put on screen
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	public static void firstPage() {

		// Add Page
		JFrame frame = new JFrame("Book Database -- Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
		

        // Add Menu
		addMenuBar(frame);
        
        JPanel welcome = new JPanel();
        JLabel message = new JLabel("Welcome to database");
        welcome.add(message);
        

        WindowClosingAction(frame);
        //
        frame.getContentPane().add(welcome,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public static void addBookPage(JFrame old)
	{
		// Add Page
		old.setVisible(false);
		final JFrame frame = new JFrame("Add book");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Add Menu
		addMenuBar(frame);
		
		JPanel page = new JPanel();
		page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
		
		// Title
        JPanel addtitlepanel = new JPanel();
        JLabel addtitle = new JLabel("Title:");
        JTextField title = new JTextField(20);
        addtitlepanel.add(addtitle);
        addtitlepanel.add(title);
        
        // Author
        JPanel addauthorpanel = new JPanel();
        JLabel addauthor = new JLabel("Author:");
        JTextField author = new JTextField(20);
        addauthorpanel.add(addauthor);
        addauthorpanel.add(author);
        
        
        // Genre (drop down?)
        JPanel addgenrepanel = new JPanel();
        JLabel addgenre = new JLabel("Genre:");
        JTextField genre = new JTextField(20);
        addgenrepanel.add(addgenre);
        addgenrepanel.add(genre);
        
        // Publisher
        JPanel addpublisherpanel = new JPanel();
        JLabel addpublisher = new JLabel("Publisher:");
        JTextField publisher = new JTextField(20);
        addpublisherpanel.add(addpublisher);
        addpublisherpanel.add(publisher);
        
        
        //Copy Date
        JPanel addcopyritepanel = new JPanel();
        JLabel addcopyrite = new JLabel("copyrite:");
        JTextField copyrite = new JTextField(20);
        addcopyritepanel.add(addcopyrite);
        addcopyritepanel.add(copyrite);
        
        // IBSN
        JPanel addibsnpanel = new JPanel();
        JLabel addibsn = new JLabel("copyrite:");
        JTextField ibsn = new JTextField(20);
        addibsnpanel.add(addibsn);
        addibsnpanel.add(ibsn);
        
        // Buttons
		
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        // Clear button
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event) {
                // clear text
        		title.setText("");
        		author.setText("");
        		publisher.setText("");
        		genre.setText("");
        		ibsn.setText("");
        		copyrite.setText("");
            }
        });
        JButton enter = new JButton("Enter");
        enter.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event) {
                // clear text
        		if(title.getText().isEmpty() || author.getText().isEmpty())
        		{
        			System.out.print("Didn't enter anything");
        		}
        		else
        		{
	        		//Book new_book = new Book(new_title[0],new_author[0], new_genre[0], new_isbn[0], new_publisher[0], new_copyrite[0]);
	        		Book new_book = new Book(title.getText(),author.getText(),genre.getText(),ibsn.getText(),publisher.getText(),copyrite.getText());
	        		//System.out.println(new_book);
	        		// Compare to database
	        		
	        		System.out.print("Compare: " +FinalProject.MainBookDatabase.compare(new_book));
	        		if(!FinalProject.MainBookDatabase.compare(new_book)) {
	
	        			
	            		// Add to database
	        			FinalProject.MainBookDatabase.add(new_book);
	        			
	        		}
	        		else
	        		{
	        			System.out.println("Book already exists");
	        			// Print some kind of pop up that book already exists
	        			// do you have two copies?
	        		}
        		}
        		
        		// clear fields
        		title.setText("");
        		author.setText("");
        		publisher.setText("");
        		genre.setText("");
        		ibsn.setText("");
        		copyrite.setText("");
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event) {
        		frame.dispose();
                // go to database page or first page
        		Design.firstPage();
        	}
            
        });
        buttons.add(clear);
        buttons.add(enter);
        buttons.add(exit);
        
        // Add to page panel
        page.add(addtitlepanel);
        page.add(addauthorpanel);
        page.add(addgenrepanel);
        page.add(addpublisherpanel);
        page.add(addcopyritepanel);
        page.add(addibsnpanel);
        page.add(buttons);
        

        WindowClosingAction(frame);
        
        // Add page to frame
        frame.getContentPane().add(BorderLayout.CENTER,page);
        frame.setVisible(true);
	}
	public static void addMenuBar(JFrame frame) {
		// Menu
        JMenuBar menu = new JMenuBar();
        JMenu display = new JMenu("Database");
        JMenuItem data = new JMenuItem("View");
        data.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event) {
        		viewDatabasePage(frame);
            }
        });
        JMenu addItem = new JMenu("Add");
        JMenuItem addbook = new JMenuItem("Book");
        addbook.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event) {
        		addBookPage(frame);
            }
        });
       
        JMenuItem addperson = new JMenuItem("Person");
        display.add(data);
        addItem.add(addbook);
        addItem.add(addperson);
        menu.add(display);
        menu.add(addItem);
        

        frame.getContentPane().add(BorderLayout.NORTH,menu);
	}
	
	public static void WindowClosingAction(JFrame frame)
	{
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
			         FileOutputStream fileOut = new FileOutputStream("bookdata.ser");
			         System.out.println(fileOut.toString());
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(FinalProject.MainBookDatabase);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in bookdata");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}

