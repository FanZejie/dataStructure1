import java.util.Arrays;

/**
 * 采用分治策略
 * @author Mike
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];//归并排序需要一个额外空间
        System.out.println("排序前数组为："+ Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("排序后数组为："+ Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引
        //1.先把左右两边（有序）的数据按照规则填充到temp数组，知道左右两边的有序序列又一边处理完为止
        while (i<=mid&&j<=right){
            if (arr[i]<arr[j]){
                temp[t] = arr[i];
                t+=1;
                i+=1;
            }else {
                temp[t] = arr[j];
                t+=1;
                j+=1;
            }

        }
        //2.把还有剩余数据的一边剩下的树填充到temp
        while(i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3.将temp数组的元素拷贝到arr
        //注意，不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
