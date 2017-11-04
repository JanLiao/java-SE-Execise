public class ClassLoaderTest{

    public int maximumProduct(int[] num) {
        if(num.length == 3) return num[0]*num[1]*num[2];
        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];
        for(int i = 0; i < num.length; i++){
            if(num[i] >= 0) arr1[num[i]]++;
            else{
                int tmp = 0 - num[i];
                arr2[tmp]++;
            }
        }
        int sum1 = 1;
        int flag1 = 2;
                for(int i = 1000; i >= 0; i--){
            if(arr1[i] != 0){
                sum1 = sum1 * i;
                break;
            }
        }
        int sum = 1;
        int flag = 3;
        for(int i = 1000; i >= 0; i--){
            while(arr1[i] > 0){
                if(flag > 0){
                    sum = sum*i;
                    flag--;
                    arr1[i]--;
                }else{
                    break;
                }
            }
            if(flag == 0) break;
        }

        for(int i = 1000; i >= 0; i--){
            while(arr2[i] > 0){
                if(flag1 > 0){
                    sum1 = sum1*(0 - i);
                    flag1--;
                    arr2[i]--;
                }else{
                    break;
                }
            }
            if(flag1 == 0) break;
        }
        System.out.println("sum1 = " + sum1);
        for(int i = 1000; i >= 0; i--){
            if(arr1[i] != 0){
                sum1 = sum1 * i;
                break;
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("sum1 = " + sum1);
        if(sum > sum1) return sum;
        return sum1;
    }

	public static void main(String[] args){
		ClassLoader loader = System.class.getClassLoader();
		System.out.println(loader != null ? loader.getClass().getName() : null);
		// System.out.println(CollationData_ar.class.getClassLoader().getClass().getName());
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());

		ClassLoader load = ClassLoaderTest.class.getClassLoader();
		load = load.getParent();
		System.out.println("当前类加载器的超类加载器--->" + load.getClass().getName());

		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0};
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; (j < arr.length); j++){
				if(j == i) continue;
				System.out.print("j = " + j + " ");
			}
			System.out.println();
		}

		int[] arr1 = new int[]{0,0,0,4};

		ClassLoaderTest ct = new ClassLoaderTest();
		ct.maximumProduct(arr1);
	}
}