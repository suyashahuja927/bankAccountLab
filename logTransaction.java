void logTransaction(char type, int amount, int balance) {
	switch (type) {
	case 'c':
		balance += amount;
		System.out.println("Credited: £" + amount);
		System.out.println("Account balance: £" + balance);
		break;
	case 'd':
		balance -= amount;
		System.out.println("Debited: £" + amount);
		System.out.println("Account balance: £" + balance);
		break;
	case 'f':
		System.out.println("Transaction has been flagged so no action taken.");
		System.out.println("Account balance: £" + balance);
		break;
	}
}