package javaClasses;


public class BankAccountVersion2 {

	private int accountNumber;
	private String name;
	private double balance;
	private boolean isActive;
	
	public BankAccountVersion2(int accountNumber,String name,double balance,boolean isActive){
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.isActive = isActive;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(balance>amount){
			balance = balance-amount;
		}else{
			throw new InsufficientBalanceException();
		}
	}
	
	public void deposit(double amount){
		balance = balance+amount;
	}
	
	public double getBalance(){
		return balance;
	}
}
