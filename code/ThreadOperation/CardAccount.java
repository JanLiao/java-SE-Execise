public class CardAccount{
	private String cid;
	private int balance;

	public CardAccount(String cid,int balance){
		this.cid=cid;
		this.balance=balance;
	}

	public String getCid(){
		return this.cid;
	}

	public void setCid(String cid){
		this.cid=cid;
	}

	public int getBalance(){
		return this.balance;
	}

	public void setBalance(int balance){
		this.balance=balance;
	}

	public String toString(){
		return "{"+cid+"}";
	}
}