import java.util.Arrays;

/**
 * @author Mike
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        //testSort(arr);
        radixSort(arr);
    }
    public static void radixSort(int[] arr){
        //1.得到数组中最大值的位数
        int max = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        //得到最大数是几位数,把它转成字符串，然后看长度
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0,n=1;i<maxLength;i++,n*=10){
            for (int j=0;j<arr.length;j++){
                //取出每个元素的个位数
                int digit = arr[j]/n%10;
                //放入对应的桶中
                bucket[digit][bucketElementCounts[digit]] = arr[j];
                bucketElementCounts[digit]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一桶，并将桶中的数据放入到原数组
            for (int k = 0;k < bucketElementCounts.length;k++){
                //如果桶中有数据，放回到原数组
                if (bucketElementCounts[k]!=0){
                    for (int l = 0;l<bucketElementCounts[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后，需要将每个桶bucketElementCounts[k]=0
                bucketElementCounts[k] = 0;
            }
            System.out.println("对"+(i+1)+"位数的排序完毕后："+ Arrays.toString(arr));
        }
    }
    public static void testSort(int[] arr){
        //定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        //1.对每个元素的个位数进行排序处理
        for (int j=0;j<arr.length;j++){
            //取出每个元素的个位数
            int digit = arr[j]/1%10;
            //放入对应的桶中
            bucket[digit][bucketElementCounts[digit]] = arr[j];
            bucketElementCounts[digit]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        int index = 0;
        //遍历每一桶，并将桶中的数据放入到原数组
        for (int k = 0;k < bucketElementCounts.length;k++){
            //如果桶中有数据，放回到原数组
            if (bucketElementCounts[k]!=0){
                for (int l = 0;l<bucketElementCounts[k];l++){
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后，需要将每个桶bucketElementCounts[k]=0
            bucketElementCounts[k] = 0;
        }
        System.out.println("对个位数的排序完毕后："+ Arrays.toString(arr));
        //2.对每个元素的十位数进行排序处理
        for (int j=0;j<arr.length;j++){
            //取出每个元素的个位数
            int digit = arr[j]/10%10;
            //放入对应的桶中
            bucket[digit][bucketElementCounts[digit]] = arr[j];
            bucketElementCounts[digit]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        index = 0;
        //遍历每一桶，并将桶中的数据放入到原数组
        for (int k = 0;k < bucketElementCounts.length;k++){
            //如果桶中有数据，放回到原数组
            if (bucketElementCounts[k]!=0){
                for (int l = 0;l<bucketElementCounts[k];l++){
                    arr[index++] = bucket[k][l];
                }
            }
            //第2轮处理后，需要将每个桶bucketElementCounts[k]=0
            bucketElementCounts[k] = 0;
        }
        System.out.println("对十位数的排序完毕后："+ Arrays.toString(arr));
        //3.对每个元素的十位数进行排序处理
        for (int j=0;j<arr.length;j++){
            //取出每个元素的个位数
            int digit = arr[j]/100%10;
            //放入对应的桶中
            bucket[digit][bucketElementCounts[digit]] = arr[j];
            bucketElementCounts[digit]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        index = 0;
        //遍历每一桶，并将桶中的数据放入到原数组
        for (int k = 0;k < bucketElementCounts.length;k++){
            //如果桶中有数据，放回到原数组
            if (bucketElementCounts[k]!=0){
                for (int l = 0;l<bucketElementCounts[k];l++){
                    arr[index++] = bucket[k][l];
                }
            }
            //第3轮处理后，需要将每个桶bucketElementCounts[k]=0
            bucketElementCounts[k] = 0;
        }
        System.out.println("对百位数的排序完毕后："+ Arrays.toString(arr));
    }
}
