import java.util.Arrays;

public class Bank{
	
	private CardAccount[] accounts;
	
	private int[] accountOne = new int[]{4,3,3,4,2,1,6,7,5,5,4,4,8,0,0,7};
	private int[] accountTwo = new int[]{4,3,3,4,2,1,6,7,5,5,4,4,8,5,0,8};
	private int[] accountThree = new int[]{4,3,3,4,2,1,0,7,0,5,4,4,8,0,0,5};
	
	private String nameOne = "Alice Smith";
	private String nameTwo = "Osian Jones";
	private String nameThree = "Claire Bevan";
	
	public Bank()
	{
		accounts = new CardAccount[3];
		accounts[0] = new CardAccount(accountOne,nameOne);
		accounts[1] = new CardAccount(accountTwo,nameTwo);
		accounts[2] = new CardAccount(accountThree,nameThree);
	}
	
	public CardAccount handleTransaction(int[]accountNumber, String name, float amount,char type)
	{
		boolean accountFound = false;
		CardAccount foundAccount=null;
		for(int position=0;position<accounts.length;position++)
		{
			if(Arrays.equals(accountNumber, accounts[position].getAccountNumber()))
			{
				accountFound=true; 
				if(accounts[position].checkName(name))
				{
					accounts[position].processTransaction(type, amount);
					foundAccount=accounts[position];
				}
				else
				{
					System.out.println("Incorrect name");
				}
			}
		}
		if(!accountFound)
		{
			System.out.println("No matching account found");
		}
		return foundAccount;
	}
	
	public CardAccount[] getAccounts()
	{
		return accounts;
	}
	
	public static void main(String[] args)
	{

	}	
}
