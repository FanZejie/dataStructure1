import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Mike
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        /*int arr[] = {3,9,-1,10,-3};
        System.out.println("排序前数组为："+ Arrays.toString(arr));
        int temp = 0;
        //testSort(arr);
        //sort(arr);
        betterSort(arr);
        System.out.println("排序后数组为："+ Arrays.toString(arr));*/
        testSortTime();
    }
    public static void betterSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i<arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                //如果前面的数比后面的数大，就交换,并把flag置为true
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag){//如果没有发生交换，说明已经排序好了，直接跳出就行
                break;
            }else {
                flag = false;
            }
        }
    }

    public static void sort(int[] arr) {
        int temp;
        for (int i = 0; i<arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                //如果前面的数比后面的数大，就交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 通过观察每一次的排序找出规律
     * @param arr
     */
    public static void testSort(int[] arr) {
        int temp;
        //第一次排序
        for (int j = 0; j<arr.length-1; j++){
            //如果前面的数比后面的数大，就交换
            if (arr[j]>arr[j+1]){
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("第一次排序后的结果为："+ Arrays.toString(arr));

        //第二次排序
        for (int j = 0;j<arr.length-1-1;j++){
            //如果前面的数比后面的数大，就交换
            if (arr[j]>arr[j+1]){
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("第二次排序后的结果为："+Arrays.toString(arr));
        //第三次排序
        for (int j = 0;j<arr.length-1-2;j++){
            //如果前面的数比后面的数大，就交换
            if (arr[j]>arr[j+1]){
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("第三次排序后的结果为："+Arrays.toString(arr));
        //第四次排序
        for (int j = 0;j<arr.length-1-3;j++){
            //如果前面的数比后面的数大，就交换
            if (arr[j]>arr[j+1]){
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("第四次排序后的结果为："+Arrays.toString(arr));
        //通过对比规律我们不难发现，j<arr.length-第几次排序，而一共要排序arr.length-1次
    }

    /**
     * 测试排序所花时间
     */
    public static void testSortTime(){
        int bigArr[] = new int[8*10000];
        for (int i = 0;i<bigArr.length;i++){
            bigArr[i] = (int)(Math.random()*8000000);//生成一个[0,8000000)的数放入数组
        }
        Date before = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeStr = simpleDateFormat.format(before);
        System.out.println("排序前时间为："+beforeStr);
        betterSort(bigArr);
        Date after = new Date();
        String afterStr = simpleDateFormat.format(after);
        System.out.println("排序后时间为："+afterStr);
    }
}
