//package jvm.GC;
//
//import jvm.GC.sugar.eums.eums;
//
//import java.util.Scanner;
//
///**
// * @ClassName GCtest
// * @Author laixiaoxing
// * @Date 2019/3/25 下午11:23
// * @Description 垃圾回收测试和GC日志观察
// * @Version 1.0
// */
//public class GCtest {
//
//    private static final int _1MB = 1024 * 1024;
//
//
//    public static void testAllocation() throws InterruptedException {
//        Thread.sleep(5000);
//        byte[] allocation1, allocation2, allocation3, allocation4;
//        allocation1 = new byte[ 2*_1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
//        allocation4 = new byte[200 * _1MB];
//        Scanner in =new Scanner(System.in);
//        //输入一个整数
//        int a=in.nextInt();
//        System.out.println(a);
//        System.out.println("");
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//        testAllocation();
//    }
//}
