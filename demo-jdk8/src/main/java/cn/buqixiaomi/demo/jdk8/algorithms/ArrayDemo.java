package cn.buqixiaomi.demo.jdk8.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * description
 * 数组算法
 * @author lishengkai
 * @date 2018-09-20 10:04
 */
public class ArrayDemo {


    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("-----------------逆序----------");
        System.out.println(Arrays.toString(ints));
        reverseSelf(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("-----------------逆序----------");
        System.out.println(Arrays.toString(ints));
        reverseTools(ints);
        System.out.println(Arrays.toString(ints));

        Integer[] integers = {5,6,3,8,7,2,1,9,4,10,4};
        List<Integer> list = Arrays.asList(integers);
        System.out.println("-----------------逆序数----------");
        Integer[] integers2 = {5,6,3,8};
        System.out.println(Arrays.toString(integers));
        System.out.println(inverseCount(integers,0,integers.length -1));
        System.out.println("-----------------冒泡排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        bubbingSort(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println("-----------------快速排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        fastSort(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println("-----------------选择排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        selectSort(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println("-----------------插入排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        insertionSort(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println("-----------------希尔排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        hillSort(integers);
        System.out.println(Arrays.toString(integers));

        System.out.println("-----------------归并排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        mergeSort(integers,0,integers.length-1);
        System.out.println(Arrays.toString(integers));

        System.out.println("-----------------堆排序----------");
        Collections.shuffle(list);
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));
        heapSort(integers);
        System.out.println(Arrays.toString(integers));

        System.out.println("-----------------递归二分查找----------");
        System.out.println(Arrays.toString(integers));
        System.out.println(binarySearch(integers,9,0,10));
        System.out.println("-----------------普通二分查找----------");
        System.out.println(Arrays.toString(integers));
        System.out.println(binarySearch(integers,4,0,10));
    }

    /**
     * 递归二分查找
     * @param ts
     * @param key
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static Integer binarySearch(Integer[] ts,int key,int beginIndex,int endIndex){
        if (beginIndex == endIndex){
            if (ts[beginIndex] == key){
                return beginIndex;
            }else {
                return null;
            }
        }else{
            int midIndex = (beginIndex + endIndex) /2;
            if (ts[midIndex] == key){
                return midIndex;
            }
            if (ts[midIndex] < key){
               return binarySearch(ts,key,midIndex +1,endIndex);
            }else {
                return binarySearch(ts,key,beginIndex,midIndex);
            }
        }
    }

    /**
     * 非递归实现二分查找
     * @param ts
     * @param key
     * @return
     */
    public static Integer commonBinarySearch(Integer[] ts,int key){
        int beginIndex = 0;
        int endIndex = ts.length -1;
        int midIndex ;
        while (beginIndex <= endIndex){
            midIndex = (endIndex + beginIndex) /2;
            if (midIndex == beginIndex){
                if (ts[midIndex] == key){
                    return midIndex;
                }else {
                    break;
                }
            }else {
                if (ts[midIndex] < key){
                    beginIndex = midIndex + 1;
                }else {
                    endIndex = midIndex;
                }
            }
        }
        return null;
    }

    /**
     * 堆排序
     * 将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。
     * 将它移走(其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值)，
     * 然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中的次最大值。
     * 如此反复执行，就能得到一个有序序列了
     * @param ts
     */
    public static void heapSort(Integer[] ts){
        for (int i=ts.length/2;i>=0;i--){
            heapAdjust(ts,i,ts.length);
        }
        for (int j = ts.length -1 ;j>0;j--){
            int tmp = ts[0];
            ts[0] = ts[j];
            ts[j] = tmp;
            heapAdjust(ts,0,j);
        }

    }

    private static void heapAdjust(Integer[] ts, int index, int length) {
        int child = 0;
        int father = 0;
        for (father = ts[index];leftChild(index)<length;index=child){
            child = leftChild(index);
            if (child != length -1 && ts[child] < ts[child +1]){
                child++;
            }
            if (father <ts[child]){
                ts[index] = ts[child];
            }else {
                break;
            }
        }
        ts[index] = father;
    }

    private static int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 归并排序
     * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。
     * 然后再把有序子序列合并为整体有序序列
     * @param ts
     */
    public static void mergeSort(Integer[] ts,int beginIndex,int endIndex){
        int midIndex = (beginIndex + endIndex)/2;
        if (beginIndex < endIndex){
            mergeSort(ts,0,midIndex);
            mergeSort(ts,midIndex +1,endIndex);
            merge(ts,beginIndex,midIndex,endIndex);
        }
    }

    private static void merge(Integer[] ts, int beginIndex, int midIndex, int endIndex) {
        int[] tmp = new int[endIndex-beginIndex +1];
        int i = beginIndex;
        int j = midIndex +1;
        int k =0;
        //把左右中最小的依次放在tmp 中，直到某一边被移动完
        while (i<=midIndex && j<=endIndex){
            if (ts[i] <= ts[j]){
                tmp[k++] = ts[i++];
            }else {
                tmp[k++] = ts[j++];
            }
        }
        //把左边剩余的依次放到tmp
        while (i<=midIndex){
            tmp[k++] = ts[i++];
        }
        //把右边剩余的依次放到tmp
        while (j<=endIndex){
            tmp[k++] = ts[j++];
        }
        //替换到原数组中
        for (int m=0;m<tmp.length;m++){
            ts[m + beginIndex] = tmp[m];
        }
    }

    /**
     * 希尔排序
     * 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
     * 然后依次缩减增量再进行排序，
     * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序
     * @param ts
     */
    public static void hillSort(Integer[] ts){
        int j = 0;
        int tmp = 0;
        for (int increment = ts.length/2;increment>0;increment/=2){
            for (int i = increment;i<ts.length;i++){
                tmp = ts[i];
                for (j = i;j>=increment;j-=increment){
                    if (tmp<ts[j-increment]){
                        ts[j] = ts[j-increment];
                    }else {
                        break;
                    }
                }
                ts[j] = tmp;
            }
        }
    }

    /**
     * 插入排序
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果前一个比当前值大，则把前一个往后移一位，直到不大的时候，此时，当前值应该放在此位置
     * @param ts
     */
    public static void insertionSort(Integer[] ts){
        if (ts.length <=1){
            return;
        }
        int tmp = 0;
        int j =0;
        for (int i = 0;i<ts.length;i++){
            tmp = ts[i];
            for (j = i;j>0 && tmp <ts[j-1];j--){
                ts[j] = ts[j-1];
            }
            ts[j] = tmp;
        }
    }

    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * @param ts
     */
    public static void selectSort(Integer[] ts){
        if (ts.length <=1){
            return;
        }
        int tmp = 0;
        for (int i =0;i<ts.length;i++){
            //当前最小的值所在索引
            int k = i;
            //找到剩余列表中，最小的
            for (int j = ts.length -1 ;j>i;j--){
                if (ts[j]<ts[k]){
                    k = j;
                }
            }
            //把最小的放前面
            tmp = ts[i];
            ts[i] = ts[k];
            ts[k] = tmp;
        }
    }

    /**
     * 快速排序
     * 在数据集之中，选择一个元素作为”基准”（pivot）。
     * 所有小于”基准”的元素，都移到”基准”的左边；所有大于”基准”的元素，都移到”基准”的右边。这个操作称为分区 (partition) 操作，
     *      分区操作结束后，基准元素所处的位置就是最终排序后它的位置。
     * 对”基准”左边和右边的两个子集，不断重复第一步和第二步，直到所有子集只剩下一个元素为止。
     * @param ts
     */
    public static void fastSort(Integer[] ts){
        if (ts.length>0){
            fastStart(ts,0,ts.length -1);
        }
    }

    /**
     * 内部递归
     * @param ts
     * @param beginIndex
     * @param endIndex
     */
    private static void fastStart(Integer[] ts, int beginIndex, int endIndex) {
        if (beginIndex < endIndex){
            int midIndex = getMidIndex(ts,beginIndex,endIndex);
            fastStart(ts,beginIndex,midIndex-1);
            fastStart(ts,midIndex +1,endIndex);
        }
    }

    /**
     * 左右移动
     * @param ts
     * @param beginIndex
     * @param endIndex
     * @return
     */
    private static int getMidIndex(Integer[] ts, int beginIndex, int endIndex) {
        int tmp = ts[beginIndex];
        while (beginIndex < endIndex){
            //从后开始找，直到找到比基准数值小的
            while (ts[endIndex] >= tmp && beginIndex < endIndex){
                endIndex--;
            }
            //小的往前移动，这时候后边出现了一个重复了，需要有一个大的去填补
            ts[beginIndex] = ts[endIndex];
            //从前边开始找，直到找到比基准数值大的
            while (ts[beginIndex] <tmp && beginIndex < endIndex){
                beginIndex++ ;
            }
            //大的往后移动，填补之前的空缺
            ts[endIndex] = ts[beginIndex];
        }
        //最终，把基准值放在中间
        ts[beginIndex] = tmp;
        return beginIndex;
    }

    /**
     * 冒泡排序
     * 一直比较取最大的放在最后
     * @param ts
     */
    public static void bubbingSort(Integer[] ts){
        if (ts.length == 1){
            return;
        }
        int tmp = 0;
        for (int i = 0;i<ts.length;i++){
            for (int j = 0;j<ts.length-1-i;j++){
                if (ts[j]>ts[j+1]){
                    tmp = ts[j];
                    ts[j] = ts[j+1];
                    ts[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 求int数组逆序数
     * 在一个排列中，如果一对数的前后位置与大小顺序相反，即前面的数大于后面的数，那么它们就称为一个逆序。
     * 逆序数可如下计算:标出每个数右面比它小的数的个数,它们的和就是逆序数.
     * 例如求436512的逆序数:t(436512)=3+2+3+2+0+0=10.一个排列中逆序的总数就称为这个排列的逆序数。
     * 逆序数为偶数的排列称为偶排列；
     * 逆序数为奇数的排列称为奇排列。如2431中，21，43，41，31是逆序，逆序数是4，为偶排列
     * 使用归并排序
     */
    public static int inverseCount(Integer[] ts,int beginIndex,int endIndex){
        int midIndex = (beginIndex + endIndex)/2;
        if (beginIndex < endIndex){
            int left = inverseCount(ts,0,midIndex);
            int right = inverseCount(ts,midIndex +1,endIndex);
            int count = mergeCount(ts,beginIndex,midIndex,endIndex);
            return left + right + count;
        }
        return 0;
    }

    private static int mergeCount(Integer[] ts, int beginIndex, int midIndex, int endIndex) {
        int[] tmp = new int[endIndex-beginIndex +1];
        int i = beginIndex;
        int j = midIndex +1;
        int k =0;
        int count = 0;
        //把左右中最小的依次放在tmp 中，直到某一边被移动完
        while (i<=midIndex && j<=endIndex){
            if (ts[i] <= ts[j]){
                tmp[k++] = ts[i++];
            }else {
                //如果前面的大于后面的，则前面剩余的值都大于后边当前值，则逆序数需要加上之前的全部数量
                count += j-i;
                for (int m = i;m<=midIndex;m++){
                    System.out.println(ts[m] + "-"+ts[j]);
                }
                tmp[k++] = ts[j++];
            }
        }
        //把左边剩余的依次放到tmp
        while (i<=midIndex){
            tmp[k++] = ts[i++];
        }
        //把右边剩余的依次放到tmp
        while (j<=endIndex){
            tmp[k++] = ts[j++];
        }
        //替换到原数组中
        for (int m=0;m<tmp.length;m++){
            ts[m + beginIndex] = tmp[m];
        }
        return count;
    }

    /**
     * 逆序
     * @param ts
     */
    public static void reverseSelf(Integer[] ts){
        for (int i = 0,j=ts.length-1;i<j;i++,j--){
            int tmp = ts[i];
            ts[i] = ts[j];
            ts[j] = tmp;
        }
    }

    /**
     * 使用JDK工具类逆序
     * @param ts
     */
    public static void reverseTools(Integer[] ts){
        List list = Arrays.asList(ts);
        Collections.reverse(list);
        ts = (Integer[]) list.toArray();
    }



}
