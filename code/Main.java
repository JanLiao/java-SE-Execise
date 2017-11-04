import java.util.Scanner;
	
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	String c=in.nextLine();
        	System.out.println(c+a + b);
        	System.out.println(a + b);
        }
    }
}