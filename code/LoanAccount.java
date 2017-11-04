abstract class LoanAccount{
	private double interest;

	private double fund;

	public double calculateInterest(){
		interest =this.getFund()*this.getInterestRate();
		System.out.println(interest);
		return interest;
	}

	public void setFund(double fund){
		this.fund=fund;
	}

	public double getFund(){
		return this.fund;
	}

	protected abstract double getInterestRate();
}
