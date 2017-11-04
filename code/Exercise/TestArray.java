public class TestArray {
    // public int majorityElement(int[] nums) {
    //     int number = 0;
    //     int max = Integer.MIN_VALUE;
    //     int min = Integer.MAX_VALUE;
    //     for(int i = 0; i < nums.length; i++){
    //         if(max < nums[i]){
    //             max = nums[i];
    //         }
    //         if(min > nums[i]){
    //             min = nums[i];
    //         }
    //     }
    //     System.out.println(max + "======" + min);
    //     int[] arr = new int[max - min + 1];
    //     for(int i = 0; i < nums.length; i++){
    //         arr[nums[i] - min]++;
    //     }
    //     int len = (int)nums.length/2;
    //     System.out.println(len);
    //     for(int i = 0; i < arr.length; i++){

    //         if(arr[i] >= len){
    //             number = i + min;
    //         }
    //     }
    //     System.out.println(number);
    //     return number;
    // }

    // public int majorityElement(int[] nums) {
    //     int len = (int)nums.length/2;
    //     int[] arr = new int[nums.length];
    //     int num = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         int k = 0;
    //         int tmp = 0;
    //         while(k < nums.length){
    //             if(nums[k] == nums[i]){
    //                 tmp++;
    //                 k++;
    //             }else{
    //                 k++;
    //             }
    //         }
    //         System.out.println(tmp);
    //         if(tmp >= len){
    //             num = tmp;
    //             System.out.println(tmp);
    //             break;
    //         }
    //     }
    //     return num;
    // }

    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;
        for(int val : nums){
            if(count == 0){
                major = val;
                count =1;
                System.out.println("major=" + major);
                System.out.println("count=" + count);
                continue;
            }
            if(major == val) {
                count++;
            }
            else {
                count--;
            }
        }
        System.out.println(major);
        return major;
    }

    public static void main(String[] args){
        TestArray ta = new TestArray();
        int[] arr = new int[]{1,2,3,2,4,2,5,2,6,2,7,2,8,9,10};
        int tmp = ta.majorityElement(arr);
    }
}