
public class DebitCardAccount extends CardAccount{

	public DebitCardAccount(int[] accountNumber, String accountHolderName) {
		super(accountNumber, accountHolderName);
	}
	
	public void processTransaction(char type, double amount)
	{
		switch(type) {
			case 'd':
				if(balance-amount>=0)
				{
					changeBalance(-amount);
					System.out.println("Debited:£"+amount);
					System.out.println("Account balance: £"+balance);
				}
				else
				{
					changeBalance(0);
					System.out.println("Transaction declined – debit account cannot go below 0.");
				}
				break;
			default:
				super.processTransaction(type, amount);
		}
	}
}
