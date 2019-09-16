package offerword.sort;

/**
 * @ClassName FastSort
 * @Author laixiaoxing
 * @Date 2019/9/9 上午8:26
 * @Description TODO
 * @Version 1.0
 */
public class FastSort {


    public static void main(String[] args) {
       // int[] a = new int[]{3, 1, 2, 4, 5};
        int[] a = new int[]{4,4,6,5,3,2,8,1};
        fastSort(a, 0, a.length-1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }


    static void fastSort(int[] arry, int begin, int end) {

        if (begin < end) {
            int mid = getPart(arry, begin, end);
            fastSort(arry, begin, mid - 1);
            fastSort(arry, mid + 1, end);
        }
    }


    private static int getPart(int[] arry, int begin, int end) {
        //取标值
        //跟标值比较并交换位置
        //设置标值到中间去
        //返回该下标
        int tart = arry[begin];
        int index=begin;


        while (begin != end) {

            //先从右边开始 因为index是从左边开始的
            while (arry[end] > tart&&begin <end) {
                end--;
            }

            while (arry[begin] <= tart&&begin<end) {
                begin++;
            }

            //交换位置的方式
            if (begin<end){
            //交换位置
            int temp = arry[begin];
            arry[begin] = arry[end];
            arry[end] = temp;
            }
        }

        //交换位置
        int temp = arry[end];
        arry[end] = tart;
        arry[index] = temp;


        return end;
    }



}
