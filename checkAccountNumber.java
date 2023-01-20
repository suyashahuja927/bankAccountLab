void checkAccountNumber(int[] accountNumber) {
	System.out.print("Checking account: ");
	for (int count = 0; count < 16; count++) {
		System.out.print(accountNumber[count]);
	}
	System.out.println();

	int[] batwest = { 4, 3, 3, 4, 2, 1 };
	int[] boyds = { 2, 0, 0, 1, 2, 3 };
	int checkSum = 0;

	boolean validBank = true;
	boolean validPersonal = true;

	int[] compareArray = batwest;
	String comparisonBank = "batwest";

	if (boyds[0] == accountNumber[0]) {
		compareArray = boyds;
		comparisonBank = "boyds";
	}
	for (int position = 0; position < 6; position++) {
		if (accountNumber[position] != compareArray[position]) {
			validBank = false;
		}
	}
	if (validBank) {
		System.out.println("The bank managing the account is " + comparisonBank);
	} else {
		System.out.println("The bank managing the account is unrecognised");
	}
	for (int position = 6; position < 15; position++) {
		if (accountNumber[position] != 0) {
			checkSum++;
		}
		if (accountNumber[position] < 0 || accountNumber[position] > 9) {
			validPersonal = false;
		}
	}
	if (checkSum != accountNumber[15]) {
		validPersonal = false;
	}
	if (!validPersonal) {
		System.out.println("Personal account number not valid");
	} else {
		System.out.println("Personal account number valid");
	}
	if (validPersonal && validBank) {
		System.out.println("Account number valid");
	} else {
		System.out.println("Account number not valid");
	}
}