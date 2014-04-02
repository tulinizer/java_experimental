package bank;


import gui.BankFrame;

import javax.swing.JFrame;

/**
 * Transfers random amounts in a bank.
 */
public class BankLauncher
{	// main program
	public static void main(String[] args)
	{	BankFrame frame = new BankFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}


