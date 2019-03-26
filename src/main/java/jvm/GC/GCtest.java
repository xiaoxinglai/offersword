package jvm.GC;

/**
 * @ClassName GCtest
 * @Author laixiaoxing
 * @Date 2019/3/25 下午11:23
 * @Description 垃圾回收测试和GC日志观察
 * @Version 1.0
 */
public class GCtest {

    private static final int _1MB = 1024 * 1024;


    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现一次minor GC
        allocation4 = new byte[4 * _1MB];

    }


    public static void main(String[] args) {
        testAllocation();
    }
}
