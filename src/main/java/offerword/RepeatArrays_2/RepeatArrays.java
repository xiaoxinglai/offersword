package offerword.RepeatArrays_2;

import java.util.HashMap;

/**
 * @ClassName RepeatArrays
 * @Author laixiaoxing
 * @Date 2019/4/2 上午8:16
 * @Description 数组中重复的数字
 * @Version 1.0
 */
public class RepeatArrays {


    //题目一，找出数组中重复的数字
    //在一个长度为n的数组里面所有的数字都在0～n-1的范围内，里面有数字是重复的
    //请找数组中任意一个重复的数字
    //例如输入长度为7的数组{2，3，1，0，2，5，3} 那么对应的输出为2或者3

    //思路；
    //1.先排序再遍历，快排时间复杂度为logN 遍历为N
    //2.利用hashMap。时间复杂度为N,空间复杂度也为N
    //3.下标排序法，从头到尾依次扫描这个数组中的每个数字，如果这个数字等于下标，则进行扫描下一个，
    // 如果不等于下标，则拿这个数与下标为这个数的数字比较（比如3和下标为3的数字比较）
    //如果相等 则说明重复，如果不等，就交换这两个数字的位置
    //重复以上
    //时间复杂度为N 空间复杂度为1

    //思路3的简要说明： 因为在长度为n的数组里面所有的数字都在0～n-1的范围内
    // 所以可以将所有数字都跟其下标一一对应， 这样就可以找到重复的了
    //本质上也是一种排序，比如说，先从下标0的元素开始，发现是2，然后开始遍历除了下标0之外的所有元素，直到找到元素0为止
    //时间复杂度为n!

    //但是因为，每个元素只能有一个下标，所以交换下标的形式更快
    //比如说在火车上，你的位置被人占了， 占你位置的人的位置也被另一个占了，你只要找到你的位置
    //然后让他回去他的位置，依次类推， 你们就都回到了自己的位置


    public static void main(String[] args) {
        Integer[] arr = {2, 1, 2, 3, 0, 5, 3};
        methd1(arr);
        methd2(arr);
        methd3(arr);
    }


    /**
     * 二分法统计次数查找 时间复杂度n*logN 空间1
     * @param arr
     */
    public static void methd4(Integer[] arr) {
        System.out.println("二分法统计次数查找");
        //思路：将数字值所在的范围0～n-1 划分为两部分 ，先看0～n-1/2 范围内的数字出现的次数是否是大于n-1/2 是的话 ，说明这部分有重复
        //另一部分也是如此，依次递归，即可找到重复的数字
        //缺点 无法找到所🈶的重复，因为无法知道具体的重复次数

        //举例：比如说在值1～3大小的范围内，如果不重复，就是123 这三个数字应该在整个数组中各出现一次 总计出现次数为3次
        //如果值1～3大小的范围内，123这三个数字在整个数组中出现的的次数将大于3次





    }




    /**
     * 使用辅助数组做map 空间N 时间1
     */
    public static void methd3(Integer[] arr) {
        System.out.println("使用辅助表");
        System.out.println("使用辅助数组做map");
       Integer[] map=new Integer[arr.length];


        for (Integer v : arr) {
            if (map[v]==null){
                map[v]=v;
            }else {
                System.out.println("重复数字"+v);
            }
        }
    }


    /**
     * 使用hashmap 空间N 时间1
     */
    public static void methd2(Integer[] arr) {
        System.out.println("Map方法");
        HashMap<Integer,Integer> map=new HashMap<>();
        for (Integer v : arr) {
            if (map.get(v)==null){
                map.put(v,0);
            }else {
                System.out.println("重复数字"+v);
            }
        }
    }

    /**
     * 先排序再遍历 时间logN*N  空间1
     */
    public static void methd1(Integer[] arr) {


        //方法1 先排序再找重复的
        Integer[] sortArr = fastSort(arr);
        for (Integer integer : sortArr) {
            System.out.print(integer);
        }
        System.out.println();
        //一个元素等于它前一个元素 即重复
        for (int i = 0; i < sortArr.length; i++) {
            if (i!=0){
                if (sortArr[i].equals(sortArr[i-1]) ) {
                    System.out.println("重复数字"+sortArr[i]);
                }
            }

        }
    }


    private static Integer[] fastSort(Integer[] arr) {

        int i = 0;
        int j = arr.length - 1;

        sort(arr, i, j);
        return arr;
    }


    private static void sort(Integer[] arr, int i, int j) {

        if (i >= j) {
            return;
        }

        //核心方法，一趟排序 返回中间的坐标值
        int p = getPartion(arr, i, j);

        //递归调用
        sort(arr, 0, p - 1);
        sort(arr, p + 1, j);
    }


    private static int getPartion(Integer[] arr, int i, int j) {
        int keyIndex = i;
        while (i != j && i < j) {
            //让j先走，这样最后一个位置肯定就是在i那边
            while (i < j && arr[j] >= arr[keyIndex]) {
                j--;
            }
            while (i < j && arr[i] <= arr[keyIndex]) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }

        int temp = arr[keyIndex];
        arr[keyIndex] = arr[i];
        arr[i] = temp;

        return i;
    }


}
