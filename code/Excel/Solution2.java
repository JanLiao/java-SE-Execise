public class Solution2 {
    public int[] moveZeroes(int[] nums) {
        int len = nums.length;
        int s = 0;
        int t = 0;
        int move = 0;
        while(s < len){
            if(nums[s] == 0){
                break;
            }else{
                s++;
            }
        }
        move = s;
        t = s + 1;
        while(s < len){
            while(t < len){
              if(nums[t] == 0){
                  break;
              }else{
                  t++;
              }
           }
            if((t - s) > 1){
                for(int i = (s + 1); i < t; i++){
                    nums[move] = nums[i];
                    move++;
                }
                s = t;
                t = t + 1;
            }else{
                s = t;
                t = t + 1;
            }
            if(t == (len - 1)){
                for(int i = (s + 1); i < len; i++){
                    nums[move] = nums[i];
                    System.out.println(move);
                    move++;
                }
                break;
            }
        }
        for(int i = move; i < len; i++){
            nums[i] = 0;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] a = new int[]{0, 0, 1};
        Solution2 s = new Solution2();
        int[] b = s.moveZeroes(a);
        for(int i = 0; i < 3; i++){
            System.out.println(b[i]);
        }
    }
}