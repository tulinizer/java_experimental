package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bank.Bank;
import bank.TransferRunnable;

/**
 * The frame containing the panel displaying accounts and the panel or the
 * buttons are for starting and close the application.
 */
public class BankFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// default width of the window
	public static final int DEFAULT_WIDTH = 450;
	// default height of the window
	public static final int DEFAULT_HEIGHT = 275;
	// panel in which the accounts are displayed
	private BankTable table;
	// bank associated this Frame
	private Bank bank;
	// number of transfer agents
	private int nbreAgents;
	// button to start an agent
	private JButton startButton;

	/**
	 * Constructor.
	 * 
	 */
	public BankFrame() {
		bank = new Bank();
		nbreAgents = 0;
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("TP02 - Bank operations");
		// creating panels for accounts and buttons
		table = new BankTable(bank);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		// creation of the button used to initiate a transfer agent
		{
			startButton = new JButton("Start (0)");
			buttonPanel.add(startButton);
			ActionListener listener = new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addTransfertAgent();
				}
			};
			startButton.addActionListener(listener);
		}
		// creation of the button used to close the application
		{
			JButton button = new JButton("Finish");
			buttonPanel.add(button);
			ActionListener listener = new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			};
			button.addActionListener(listener);
		}
	}

	/**
	 * Launching a new transfer agent
	 */
	public void addTransfertAgent() {
		nbreAgents++;
		TransferRunnable tr = new TransferRunnable(bank, table);
		Thread t = new Thread(tr);
		t.start();
		startButton.setText("Start(" + nbreAgents + ")");
		repaint();
	}
}