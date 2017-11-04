public class Search {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        int[][] lenLCS = new int[len2 + 1][len1 + 1];
        for(int i = 1; i <= len2; i++){
            for(int j = 1; j <= len1; j++){
                if(c1[j - 1] == c2[i - 1]){
                    lenLCS[i][j] = lenLCS[i - 1][j - 1] + 1;
                }else{
                    if(lenLCS[i - 1][j] >= lenLCS[i][j - 1]){
                        lenLCS[i][j] = lenLCS[i - 1][j];
                    }else{
                        lenLCS[i][j] = lenLCS[i][j - 1];
                    }
                }
            }
        }
        if(lenLCS[len2][len1] == len1) return true;
        return false;
    }

    public int[][] lenLCS(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        int[][] lenLCS = new int[len2 + 1][len1 + 1];
        for(int i = 1; i <= len2; i++){
            for(int j = 1; j <= len1; j++){
                if(c1[j - 1] == c2[i - 1]){
                    lenLCS[i][j] = lenLCS[i - 1][j - 1] + 1;
                }else{
                    if(lenLCS[i - 1][j] >= lenLCS[i][j - 1]){
                        lenLCS[i][j] = lenLCS[i - 1][j];
                    }else{
                        lenLCS[i][j] = lenLCS[i][j - 1];
                    }
                }
            }
        }
        return lenLCS;
    }

    public static void main(String[] args){
        Search s = new Search();
        String s1 = "bjaajgea";
        String s2 = "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec";
        boolean flag = s.canConstruct(s1, s2);
        System.out.println(flag);
        int[][] arr = s.lenLCS(s1, s2);
        for(int i = 0; i <= s2.length(); i++){
            for(int j = 0; j <= s1.length(); j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}