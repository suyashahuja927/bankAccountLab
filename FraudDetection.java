
public class FraudDetection {
	
	public static boolean suspisciousActivityCheck(CardAccount suspectAccount)
	{
		// To make clear what is happening here I have included some extra print statements
		double threshold = suspectAccount.getMaxWithdrawal()*0.5;
		double change = suspectAccount.getBalance()-suspectAccount.getHistoricBalance()[0];
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("+++ "+CardAccount.outputNumberFormatted(suspectAccount.getAccountNumber()) + "\t +++");
		System.out.println("+++ Threshold: "+threshold +"\t +++");
		System.out.println("+++ Balance:"+suspectAccount.getBalance()+"  \t +++");
		System.out.println("+++ Historic:"+suspectAccount.getHistoricBalance()[0]+"  \t +++");
		System.out.println("+++ Change:"+ change +  "\t \t +++"); 
		
		if(change<-threshold)
		{
			System.out.println("+++ Fraud detected  \t +++");
			System.out.println("++++++++++++++++++++++++++++");
			return true;
		}
		System.out.println("+++ No Fraud detected  \t +++");
		System.out.println("++++++++++++++++++++++++++++");
		return false;
	}
}
