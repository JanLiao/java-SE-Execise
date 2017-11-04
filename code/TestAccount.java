
class AccountA extends LoanAccount{
	public double getInterestRate(){
		return 10.0;
	}
}

public class TestAccount{
	public static void main(String[] args){
		AccountA account=new AccountA();
		account.setFund(100.0);
		account.calculateInterest();
	}
}