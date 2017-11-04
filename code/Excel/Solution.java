import java.util.*;
public class Solution {
    public String[] findWords(String[] words) {
        int len = words.length;
        int num = 0;
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0;i<len;i++){
            if(judge(words[i])){
                num++;
                arr.add(words[i]);
            };
        }
        String[] ss = new String[num];
        for(int i=0;i<num;i++){
            ss[i] = arr.get(i);
        }
        return ss;
    }
    public boolean judge(String word){
        char[] c1 = new char[]{'q','w','e','r','t','y','u','i','o','p'};
        char[] c2 = new char[]{'a','s','d','f','g','h','j','k','l'};
        char[] c3 = new char[]{'z','x','c','v','b','n','m'};
        boolean flag = true;
        String str = word.toLowerCase();
        int length = word.length();
        char[] c = str.toCharArray();
        int k = 0;
        if(judgeChar(c[0])==1){
            for(int i=0;i<length;i++){
                int len = 0;
                for(int j=0;j<10;j++){
                    if(c[i]!=c1[j]){
                        len++;
                    }
                }
                if(len==10) flag = false;
            }
        }else if(judgeChar(c[0])==2){
            for(int i=0;i<length;i++){
                int len = 0;
                for(int j=0;j<9;j++){
                    if(c[i]!=c2[j]){
                        len++;
                    }
                }
                if(len==9) flag = false;
            }
        }else{
            for(int i=0;i<length;i++){
                int len = 0;
                for(int j=0;j<7;j++){
                    if(c[i]!=c3[j]){
                        len++;
                    }
                }
                if(len==7) flag = false;
            }
        }
        return flag;
    }
    public int judgeChar(char ch){
        char[] c1 = new char[]{'q','w','e','r','t','y','u','i','o','p'};
        char[] c2 = new char[]{'a','s','d','f','g','h','j','k','l'};
        char[] c3 = new char[]{'z','x','c','v','b','n','m'};
        int kk = 0;
        for(int i=0;i<10;i++){
            if(ch==c1[i]){
                kk = 1;
                break;
            }
        }
        if(kk==0){
          for(int i=0;i<9;i++){
            if(ch==c2[i]){
                kk = 2;
                break;
            }
        }
          if(kk==0)  kk = 3;
        }
        return kk;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String[] str = new String[]{"Hello", "Alaska", "Dad", "Peace","sfslkfskglsdgl","uubuh"};
        String[] sstr = s.findWords(str);
        for(String sss:sstr){
            System.out.println(sss);
        }
    }
}