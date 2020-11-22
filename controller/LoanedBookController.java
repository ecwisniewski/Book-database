package controller;

import model.LoanedBook;
import view.BookView;

public class LoanedBookController {
	private LoanedBook model;
	private BookView view;
	
	public LoanedBookController(LoanedBook model, BookView view)
	{
		this.model = model;
		this.view = view;
	}
	
}
