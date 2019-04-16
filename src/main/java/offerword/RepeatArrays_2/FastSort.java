package offerword.RepeatArrays_2;

/**
 * @ClassName FastSort
 * @Author laixiaoxing
 * @Date 2019/4/13 下午7:36
 * @Description 快速排序
 * @Version 1.0
 */
public class FastSort {


    public static void main(String[] args) {

        Integer[] arr = {2, 3, 1, 0, 2, 5, 3};
        fastSort(0, arr.length - 1, arr);
        for (Integer integer : arr) {
            System.out.print(integer);
        }
    }

    static void fastSort(Integer left, Integer right, Integer[] arr) {
        if (left >= right) {
            return;
        }
        //进行排序并获取中值
        Integer partition = getPartition(left, right, arr);
        //重复以上
        fastSort(left, partition - 1, arr);
        fastSort(partition + 1, right, arr);
    }

    /**
     * 进行排序和获取中值
     *
     * @param left
     * @param right
     * @param arr
     * @return
     */
    static Integer getPartition(Integer left, Integer right, Integer[] arr) {
        //默认中值选择为第一个left
        Integer value = arr[left];
        Integer partition = left;

        while (left < right) {

            //找右边第一个比中值小的
            while (arr[right] >= value && left < right) {
                right--;
            }

            //找左边第一个比中值大的
            while (arr[left] <= value && left < right) {
                left++;
            }


            //交换这两个位置的值
            if (arr[left] > arr[right]) {
                Integer temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //将中值放到中间
        arr[partition] = arr[left];
        arr[left] = value;

        return left;
    }
}


