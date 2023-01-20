

public class CardAccount 
{	
	private int[] accountNumber;
	protected double balance = 0;
	private String accountHolderName;
	protected double maxWithdrawal =0;
	protected double[] historicBalance = new double[3];
	
	public CardAccount(int[] accountNumber, String accountHolderName)
	{
		this.setAccountNumber(accountNumber);
		this.accountHolderName=accountHolderName;
	}	

	private void setAccountNumber(int[] accountNumber) 
	{	
		
		System.out.println("Checking account:"+outputNumberFormatted(accountNumber));
		int[] batwest = {4,3,3,4,2,1};
		int checkSum=0;
		
		boolean validBank=true;
		boolean validPersonal=true; 
		
		for(int position=0;position<6;position++)
		{
			if(accountNumber[position]!=batwest[position])
			{
				validBank=false;
			}	
		}
		
		if(validBank)
		{
			System.out.println("The bank managing the account is batwest");
		}
		else
		{
			System.out.println("The bank managing the account is unrecognised");	
		}
		
		for(int position=6;position<15;position++)
		{
			if(accountNumber[position]!=0)
			{
				checkSum++;
			}
			else if(accountNumber[position]<0)
			{
				validBank=false;
			}
		}
		
		if (checkSum!=accountNumber[15])
		{
			validPersonal=false;
			System.out.println("Personal account number not valid");
		}
		else
		{
			System.out.println("Personal account number valid");
		}
		
		if(validPersonal && validBank)
		{
			this.accountNumber = accountNumber;
			System.out.println("Account number valid");
		}
		else
		{
			System.out.println("Account number not valid");
		}
	}
	
	public boolean checkName(String name)
	{
		String[]splitCompare = name.split(" ");
		String[]splitAccount=accountHolderName.split(" ");
		
		if (!splitCompare[1].equals(splitAccount[1]))
		{
			return false;
		}
		if (!splitCompare[0].equals(splitAccount[0]))
		{
			if(splitCompare[0].charAt(0)!=splitAccount[0].charAt(0))
			{
				return false;
			}
			if (splitCompare[0].length()!=1)
			{
				return false;
			}
		}	
		return true;
	}
	
	
	
	public void processTransaction(char type, double amount)
	{
		switch(type) {
			case 'c':
				changeBalance(amount);
				System.out.println("Credited:£"+amount);
				System.out.println("Account balance: £"+balance);
				break;
			case 'd':
				changeBalance(-amount);
				System.out.println("Debited:£"+amount);
				System.out.println("Account balance: £"+balance);
				break;
			case 'f':
				changeBalance(0);
				System.out.println("Account has been flagged so no action taken.");
				System.out.println("Account balance: £"+balance);	
				break;
		}	
	}
	
	
	// Change balance is a helper method - it's a chunk of code that I found myself repeating a lot
	// so I moved it into it's own method 
	public void changeBalance(double amount)
	{
		for(int i=0;i<2;i++)
		{
			historicBalance[i]=historicBalance[i+1];
		}
		historicBalance[2]=balance;
		balance+=amount;
		if(balance>maxWithdrawal)
		{
			maxWithdrawal= balance;
		}
	}

	public int[] getAccountNumber(){
		return accountNumber;
	}
	
	public String getAccountHolderName(){
		return accountHolderName;
	}
	
	public void setAccountHolderName(String accountHolderName){
		this.accountHolderName = accountHolderName;
	}
	

	public double[] getHistoricBalance() {
		return historicBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getMaxWithdrawal() {
		return maxWithdrawal;
	}
	
	public static String outputNumberFormatted(int[]accountNumber)
	{
		String number ="";
		for(int position=0;position<16;position++)
		{
			if (position%4==0)
			{
				number+=" ";
			}
			number+=accountNumber[position];
		}
		return number;
	}
	
	
	public static void main(String[] args)
	{
		int[] account = new int[]{4,3,3,4,2,1,6,7,5,5,4,4,8,5,0,8};
		String name = "O Jones";
		
		// A simple test of fraud detection on card account
		CardAccount cardAccount = new CardAccount(account, name);
		cardAccount.processTransaction('c', 10); 				// MaxWithdrawal:10 Balance:10
		cardAccount.processTransaction('c', 80); 				// MaxWithdrawal:90 Balance:90
		cardAccount.processTransaction('d', 70); 				// MaxWithdrawal:90 Balance:20
		FraudDetection.suspisciousActivityCheck(cardAccount);   // MaxWithdrawal:90 Change:+10 	NO FRAUD
		cardAccount.processTransaction('d', 90); 				// MaxWithdrawal:90 Balance:-70
		FraudDetection.suspisciousActivityCheck(cardAccount); 	// MaxWithdrawal:90 Change:-80 	FRAUD
	}
	

}
