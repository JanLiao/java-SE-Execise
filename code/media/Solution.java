import java.util.*;
public class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        if(num1.length == 0 || num2.length == 0) return new int[0];
        int len1 = num1.length;
        int len2 = num2.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len1; i++){
            if(max < num1[i]){
                max = num1[i];
            }
            if(min > num1[i]){
                min = num1[i];
            }
        }
        for(int i = 0; i < len2; i++){
            if(max < num2[i]){
                max = num2[i];
            }
            if(min > num2[i]){
                min = num2[i];
            }
        }
        int[] arr = new int[max - min + 1];
        for(int i = 0; i < len1; i++){
            arr[num1[i] - min]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < len2; i++){
            if(arr[num2[i] - min] > 0){
                list.add(num2[i]);
                arr[num2[i] - min]--;
            }
        }
        int[] a = new int[list.size()];
        int k = 0;
        for(int i: list){
            System.out.println(i);
            a[k] = i;
            k++;
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = new int[]{-2147483648,1,2,3};
        int[] b = new int[]{1,-2147483648,-2147483648};
        Solution s = new Solution();
        int[] c = s.intersect(a, b);
    }
}