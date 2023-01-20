
public class CreditCardAccount extends CardAccount 
{
	private double overdraft;
	
	public CreditCardAccount(int[] accountNumber, String accountHolderName,double overdraft) 
	{	
		super(accountNumber, accountHolderName);
		this.overdraft = overdraft;
		maxWithdrawal = overdraft;
	}
	
	public void processTransaction(char type, double amount)
	{
		switch(type) {
			case 'd':
				if((getBalance()-amount)*-1<overdraft)
				{
					changeBalance(-amount);
					System.out.println("Debited:£"+amount);
					System.out.println("Account balance: £"+getBalance());
				}
				else
				{
					changeBalance(0);
					System.out.println("Transaction declined – overdraft limit reached");
				}
				break;
			case 'c':
				changeBalance(amount);
				System.out.println("Credited:£"+amount);
				System.out.println("Account balance: £"+balance);
				break;
			case 'f':
				changeBalance(0);
				System.out.println("Account has been flagged so no action taken.");
				System.out.println("Account balance: £"+balance);					
				break;	
		}	
	}
	
	public void changeBalance(double amount)
	{
		for(int i=0;i<2;i++)
		{
			historicBalance[i]=historicBalance[i+1];
		}
		historicBalance[2]=balance;
		balance+=amount;
		if(balance+overdraft>maxWithdrawal)
		{
			System.out.println("Old max Withdrawal:"+maxWithdrawal);
			maxWithdrawal = balance+overdraft;
			System.out.println("New max Withdrawal:"+maxWithdrawal);
		}
	}
}
