import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *选择排序的基本思想是：
 * 第一次从arr[0]~arr[n-1]中选取最小值与arr[0]交换，
 * 第2次从arr[1]~arr[n-1]中选取最小值与arr[1]交换，
 * 第3次从arr[2]~arr[n-1]中选取最小值与arr[2]交换，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值与arr[i-1]交换，
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值与arr[n-2]交换，
 * 总共通过n-1次得到有序数组
 * @author Mike
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-3};
        System.out.println("排序前数组为："+ Arrays.toString(arr));
        //testSort(arr);
        selectSort(arr);
        //testSortTime();
    }

    public static void selectSort(int[] arr) {
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮后："+ Arrays.toString(arr));
        }
    }

    /**
     * 通过逐轮演示找出规律
     * @param arr
     */
    public static void testSort(int[] arr) {
        //第一轮
        int minIndex = 0;
        int min = arr[0];
        for (int j = 0+1;j<arr.length;j++){
            if (min>arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        //将最小值放在arr[0],即交换
        if (minIndex != 0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第一轮后："+ Arrays.toString(arr));

        //第二轮
        minIndex = 1;
        min = arr[1];
        for (int j = 1+1;j<arr.length;j++){
            if (min>arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        //将最小值放在arr[0],即交换
        if (minIndex != 1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二轮后："+ Arrays.toString(arr));
        //第三轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2+1;j<arr.length;j++){
            if (min>arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        //将最小值放在arr[0],即交换
        if (minIndex != 2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第三轮后："+ Arrays.toString(arr));
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
        selectSort(bigArr);
        Date after = new Date();
        String afterStr = simpleDateFormat.format(after);
        System.out.println("排序后时间为："+afterStr);
    }
}
