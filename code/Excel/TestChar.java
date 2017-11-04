import java.io.*;
import java.net.*;
public class TestChar{
	public void generateCharacters(OutputStream out) throws Exception {
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		int start = firstPrintableCharacter;
		while(true){		
			for(int i=start;i<start+numberOfCharactersPerLine;i++){
//				System.out.print(((i-firstPrintableCharacter) % numberOfPrintableCharacters)+firstPrintableCharacter);
//				System.out.print(" ");
				out.write(((i-firstPrintableCharacter) % numberOfPrintableCharacters)+firstPrintableCharacter);
				byte bb = (byte) (((i-firstPrintableCharacter) % numberOfPrintableCharacters)+firstPrintableCharacter);
				System.out.print(bb);
				System.out.print(" ");
			}
			out.write('\r');
			out.write('\n');
			start = ((start +1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
			System.out.println();
		}
	}

	public static void main(String[] args){
		TestChar tc = new TestChar();
		try{		
			File file = new File("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			FileOutputStream osw = new FileOutputStream(file);
			tc.generateCharacters(osw);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}