package gui;


import javax.swing.JTable;

import bank.Bank;

/**
 * Table in which the bank is displayed.
 */
public class BankTable extends JTable
{	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public BankTable(Bank bank)
	{	super(new BankTableModel(bank));
		setRowSelectionAllowed(false);
		setColumnSelectionAllowed(false);
		setCellSelectionEnabled(false);
	}	
}
