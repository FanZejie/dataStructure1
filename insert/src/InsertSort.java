import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序基本思想：
 * 把n个待排序的元素看成一个有序表和一个无序表，开始时无序表只包含一个元素，无序表中包含n-1个元素
 * 排序过程中，每次从无序表中取出第一个元素，把他的排序码依次与有序表元素的排序码进行比较，把他插入到适当位置，形成新表
 * @author Mike
 */
public class InsertSort {
    public static void main(String[] args) {
        //int arr[] = {3,9,-1,10,-3};
        //System.out.println("排序前数组为："+ Arrays.toString(arr));
        //testSort(arr);
        //insertSort(arr);
        testSortTime();
    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i =1;i<arr.length;i++){
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1 != i){
                arr[insertIndex+1] = insertVal;
            }
            //System.out.println("第"+i+"轮排序结果为："+ Arrays.toString(arr));
        }
    }

    public static void testSort(int[] arr){
        //第一轮
        int insertVal = arr[1];
        int insertIndex = 1-1;//即arr[1]的前面这个数的下标
        while (insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1] = insertVal;
        System.out.println("第一轮排序结果为："+ Arrays.toString(arr));
        //第二轮
        insertVal = arr[2];
        insertIndex = 2-1;//即arr[1]的前面这个数的下标
        while (insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1] = insertVal;
        System.out.println("第2轮排序结果为："+ Arrays.toString(arr));
        //第3轮
        insertVal = arr[3];
        insertIndex = 3-1;//即arr[1]的前面这个数的下标
        while (insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1] = insertVal;
        System.out.println("第3轮排序结果为："+ Arrays.toString(arr));
    }

    public static void testSortTime(){
        int bigArr[] = new int[8*10000];
        for (int i = 0;i<bigArr.length;i++){
            bigArr[i] = (int)(Math.random()*8000000);//生成一个[0,8000000)的数放入数组
        }
        Date before = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeStr = simpleDateFormat.format(before);
        System.out.println("排序前时间为："+beforeStr);
        insertSort(bigArr);
        Date after = new Date();
        String afterStr = simpleDateFormat.format(after);
        System.out.println("排序后时间为："+afterStr);
    }
}
