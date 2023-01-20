# bankAccountLab
A few of java programs I made when I was starting out in java. These emulate how a bank functions with different card accounts and fraud detection included.

logTransaction - Logs a transcation for a bank.
checkAccountNumber - Checks if the account number provided is valid or not.
Bank - The main class of a bank
CardAccount - An abstract class which shows a basic card account
CreditCardAccount - A credit card account which emulates a credit card using inheritance from cardAccount
DebitCardAccount - A debit card account which emulates a debit card using inheritance from cardAccount
FraudDetection - A file to ensure no fraud is taking place in the bank (No one is crediting/debiting more money from their account than they're allowed)
