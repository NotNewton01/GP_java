class Ledger {
	private String id;
	private double balance;
	private int pin;

	public void deposit(double value) {
		balance += value;
	}

	public void withdraw(double value) {
		balance -= value;
	}

	public void printBalance() {
		System.out.println("Ledger " + id + ": Balance = " + balance);
	}
}