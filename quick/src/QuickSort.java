import java.util.Arrays;

/**
 * 快速排序是对冒泡排序的一种改进，基本思想是：
 * 通过一趟排序将要排序的数组分割成独立的两部分，其中一部分的所有数据都比另外一部分的数据小，再按此方法对
 * 这俩个部分分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 * @author Mike
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-1,900,4561};
        System.out.println("排序前数组为："+ Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("排序后数组为："+ Arrays.toString(arr));

    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];//中轴值
        int temp = 0;//临时变量
        //while循环的目的是让比pivot值小的放到左边，比pivot值大的放到右边
        while (l<r){
            //在pivot的左边一直找，找到大于等于pivot值才退出
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l>=r说明pivot左边的值以经全部小于pivot，右边的值已经全部大于pivot
            if (l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l] == pivot值，r--，前移
            if (arr[1] == pivot){
                r-=1;
            }
            //如果交换完后，发现这个arr[r] == pivot值, l++，后移
            if (arr[r] == pivot){
                l+=1;
            }
        }//最外层while(l<r)结束
        //如果l==r,必须l++,r--,否则会出现栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr,left,r);
            //System.out.println("向左递归 left:"+left+"r:"+r);
        }
        if (right > l){
            quickSort(arr,l,right);
            //System.out.println("向右递归 l:"+l+"right:"+right);
        }
    }
}
