package leetcode.easy.reverse;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//
///*
// * @lc app=leetcode.cn id=7 lang=java
// *
// * [7] 整数反转
// *
// * https://leetcode-cn.com/problems/reverse-integer/description/
// *
// * algorithms
// * Easy (32.01%)
// * Total Accepted:    97.2K
// * Total Submissions: 303.7K
// * Testcase Example:  '123'
// *
// * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
// *
// * 示例 1:
// *
// * 输入: 123
// * 输出: 321
// *
// *
// * 示例 2:
// *
// * 输入: -123
// * 输出: -321
// *
// *
// * 示例 3:
// *
// * 输入: 120
// * 输出: 21
// *
// *
// * 注意:
// *
// * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
// * 0。
// *
// */
public class reverse {

    public static void main(String[] args) {


        String.valueOf(123);


        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("反转之前："+list );

        Collections.reverse(list);
        System.out.println("反转之后："+list );




        StringBuffer stringBuffer=new StringBuffer("abc");
        stringBuffer.reverse();
        System.out.println("反转之后："+stringBuffer);
        System.out.println(reverse2(-123));
    }


    /**
     *
     * 1032/1032 cases passed (59 ms)
     ✔ Your runtime beats 11.29 % of java submissions
     ✔ Your memory usage beats 0.95 % of java submissions (46.6 MB)

     * @param x
     * @return
     */
    public static int reverse(int x) {

        //转为string
        String str = String.valueOf(x);
        //判断是否是负数
        Boolean isfushu = Boolean.FALSE;

        //如果是把-去掉
        if (str.startsWith("-")) {
            str = str.substring(1, str.length());
            isfushu = Boolean.TRUE;
        }

        //转为char数组
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(Integer.valueOf(String.valueOf(aChar)));
        }

        //借助集合反转
        Collections.reverse(list);


        //拼接回去
        String resutl = "";
        for (Integer integer : list) {
            resutl += integer;
        }
        if (isfushu) {
            resutl = "-" + resutl;
        }

        Integer re = 0;

        //如果溢出就返回0
        try {
            re = Integer.valueOf(resutl);
        } catch (Exception ex) {
            return re;
        }

        return re;

    }


    /**
     * 借助stringBuffer
     * @param x
     * @return
     */
    public static int reverse2(int x) {

        int temp=0;
        StringBuffer sBuffer=new StringBuffer();
        String string;
        if(x<0){
            int y=-x;
            string=sBuffer.append(y).reverse().toString();
            temp=-Integer.parseInt(string);
        }else {
            string=sBuffer.append(x).reverse().toString();
            temp=Integer.parseInt(string);
        }
        //todo 需要判断是否溢出！！
        String.valueOf(12);
        return temp;
    }


}
