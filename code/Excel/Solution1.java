public class Solution1 {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        boolean b = true;
        int len = word.length();
        char[] arr = word.toCharArray();
        int flag = 0;
        int big = 0;
        if(arr[0] > 'A' && arr[0] < 'Z'){
            flag = 1;
        }
        if(flag == 1){
            if(arr[1] > 'A' && arr[1] < 'Z'){
                big = 1;
            }else{
                big = 0;
            }
            int k =2;
            System.out.println(big);
            System.out.println(b);
            while(k < len){
                int jj;
                System.out.println(arr[k]);
                if(arr[k] >= 'A' && arr[k] <= 'Z'){
                    jj = 1;
                }else{
                    jj = 0;
                }
                System.out.println(jj);
                if(jj == big){
                    k++;
                }else{
                    b = false;
                    break;
                }
            }
            System.out.println(b);
            return b;
        }else{
            for(int i = 1; i < len; i++){
                if(arr[i] > 'A' && arr[i] < 'Z'){
                    
                }else{
                    b =false;
                    break;
                }
            }
            return b;
        }
    }

    public static void main(String[] args){
        Solution1 s = new Solution1();
        System.out.println(s.detectCapitalUse("USZ"));
    }
}