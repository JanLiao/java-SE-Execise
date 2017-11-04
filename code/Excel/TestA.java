public class TestA{
	public void printA(int[][] array){
		int len = 0;
		System.out.println(array[0][0]);
		len++;
		int flag = 0;
		while(len<=5){
			if(flag==0){
				for(int i=0;i<=len;i++){
					if(i>2||(len-i)>3){						
					}else{
						System.out.println(array[i][len-i]);						
					}
				}
				flag=1;
			}else if(flag==1){
				for(int i=0;i<=len;i++){
					if(i>3||(len-i)>2){

					}else{						
						System.out.println(array[len-i][i]);
					}
				}
				flag=0;
			}
			len++;
		}
	}
	public static void main(String[] args){
		int[][] array = new int[3][4];
		int k = 1;
		for(int i =0;i<3;i++){
			for(int j=0;j<4;j++){
				array[i][j] = k;
				k++;
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				System.out.print(" "+array[i][j]);
			}
		}
		System.out.println();
		TestA ta = new TestA();
		ta.printA(array);
	}
}