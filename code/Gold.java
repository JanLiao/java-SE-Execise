interface Metal{
	public void twinkle();
}

interface Substitution{
	public void exchange();
}

public class Gold implements Metal,Substitution{
	public void exchange(){
		System.out.println("Exchange");
	}

	public void twinkle(){
		System.out.println("Shining");
	}

	public static void main(String[] args){
		Gold gold=new Gold();
		gold.exchange();
		gold.twinkle();
	}
}