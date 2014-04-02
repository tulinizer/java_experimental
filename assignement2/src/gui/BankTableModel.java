package gui;


import javax.swing.table.AbstractTableModel;

import bank.Bank;

/**
 * Interface class between the table and the data contained in the bank
 */
public class BankTableModel extends AbstractTableModel
{	private static final long serialVersionUID = 1L;
	// column titles
	private String[] columnNames = {"Compte","Solde"};
	// bank that appears
	private Bank bank;
    
	/**
	 * Constructor.
	 * 
	 * @param	bank	bank that appears
	 */
    public BankTableModel(Bank bank)
    {	this.bank = bank;
    }

    /**
     * returns the number of columns in the table.
     * 
     * @return	number of columns
     */
    public int getColumnCount()
    {	return columnNames.length;
    }
    
    /**
     * returns the number of rows in the table.
     * 
     * @return	number of lines
     */
    public int getRowCount()
    {	return bank.NACCOUNTS+1;
    }
    
    /**
     * returns the name of a column.
     * 
     * @param	col number of the column
     * @return	name of a column.
     */
    public String getColumnName(int col)
    {	return columnNames[col];
    }
    
    /**
     * returns the value of a cell.
     * 
     * @param	row	number of the line
     * @param	col	number of the column
     * @return	value of a cell.
     */
    public Object getValueAt(int row, int col)
    {	Object result=null;
    	if(col==0)
    		if(row==bank.NACCOUNTS)
    			result = "Total";
    		else
    			result = new String(Integer.toString(row));
    	else
    		if(row==bank.NACCOUNTS)
    			result = new Double(bank.getTotalBalance());	
    		else
    			result = new Double(bank.getBalance(row));
    	return result;
    }

    /**
     * returns the class stored in a column.
     * 
     * @param	col	number of the column
     * @return	class data
     */
    public Class<?> getColumnClass(int col)
    {	Class<?> result=null;
    	if(col==0)
    		result = String.class;
    	else
    		result = Double.class;
    	return result;
    }
}
