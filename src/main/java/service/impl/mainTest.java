package service.impl;

import service.ISouCheService;

import java.io.File;

/**
 * @ClassName main
 * @Author laixiaoxing
 * @Date 2019/4/20 下午7:10
 * @Description TODO
 * @Version 1.0
 */
public class mainTest {
    public static void main(String[] args) {

        File file = new File("/Users/laixiaoxing/Documents/offersword/src/test/java/impl/SoucheServiceTest.java");
        System.out.println(file.getName());
        System.out.println(file.exists());


        ISouCheService service = new SoucheService();
        service.soucheService();
    }
}
