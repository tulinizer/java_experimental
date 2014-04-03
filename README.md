java_experimental
=================

This program simulates a bank containing NACCOUNTS = 10 bank accounts. Each account is initialized with an amount of INITIAL_BALANCE = 1000 euros. Each click on the Start button, an agent is created, implemented by a thread. The agent performs STEPS = 3000 money transfers between accounts randomly selected, and also a random amount. The number in parentheses located in the Start button shows the number of agents created.

The last line of the table shows the sum of all accounts.Theoretically, this total must always be equal to 1000 x 10 = 10000€, since initial money is redistributed internally in the bank.

To run the program, execute BankLauncher.
