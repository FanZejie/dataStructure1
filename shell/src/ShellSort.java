import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序也是一种插入排序，是插入排序的缩小增量版本
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，
 * 每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 * @author Mike
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前数组为："+ Arrays.toString(arr));
        testSort(arr);
        //shellSort2(arr);
        //testSortTime();
    }
    public static void testSort(int[] arr){
        int temp = 0;
        int count = 0;
        //第一轮,10个数据，所以分为5组
        for (int i = 5;i<arr.length;i++){
            //遍历各组中所有的元素（共5组，每组有两个元素），步长5
            for (int j = i-5;j>=0;j-=5){
                if (arr[j]>arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("第1轮后："+Arrays.toString(arr));
        //第2轮,5/2=2组
        for (int i =2;i<arr.length;i++){
            //遍历各组中所有的元素（共2组，每组有5个元素），步长2
            for (int j = i-2;j>=0;j-=2){
                if (arr[j]>arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("第2轮后："+Arrays.toString(arr));
        //第3轮,2/2=1组
        for (int i =1;i<arr.length;i++){
            //遍历各组中所有的元素（共2组，每组有5个元素），步长2
            for (int j = i-1;j>=0;j-=1){
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("第3轮后："+Arrays.toString(arr));
    }
    public static void shellSort2(int[] arr){
        //增量gap，并逐步缩小增量
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int i = gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if (arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j = j-gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
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
        shellSort2(bigArr);
        Date after = new Date();
        String afterStr = simpleDateFormat.format(after);
        System.out.println("排序后时间为："+afterStr);
    }
}
