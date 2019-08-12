//package jvm.GC.automaticCasePacker;
//
///**
// * @ClassName automaticCasePacker
// * @Author laixiaoxing
// * @Date 2019/4/20 上午9:54
// * @Description 自动装箱
// * @Version 1.0
// */
//public class automaticCasePacker {
//
//    public static void main(String[] args) {
//        Integer a=1;
//        Integer b=2;
//        Integer c=3;
//        Integer d=3;
//        Integer e=321;
//        Integer f=321;
//        Long g=3L;
//        Integer h=Integer.valueOf(3);
//        Integer i=Integer.parseInt("3");
//        Integer j=new Integer(3);
//        int k=3;
//        //true
//        System.out.println(c==d);
//        //true
//        System.out.println(c==h);
//
//        //false  因为Integer会缓存-128 到+128之间范围的数字  == 运算符在不遇到算术运算的情况下不会自动拆箱，所以在这之间的 都相等
//        //321不在缓存范围内 因此不相等 这是两个对象 两个Integer对象的地址不同 ==比较的是地址
//        System.out.println(e==f);
//        //true
//        System.out.println(e.equals(f));
//        //true
//        System.out.println(c==i);
//        //true 即使是用new 创建的 正负128范围内也一样走了缓存
//        System.out.println(c==i);
//        //遇到低级的类型会自动拆箱
//        System.out.println(k==c);
//        //true 会自动拆箱 转为int
//        System.out.println(c==(a+b));
//        //true
//        System.out.println(c.equals(a+b));
//        //true 会自动转换 a+b拆箱为int 再转为long
//        System.out.println(g==(a+b));
//        //false g为Long  a+b为int  equals不处理数据类型，如果数据类型不同，比较就是false
//        System.out.println(g.equals(a+b));
//
//        //false g为Long c为Integer  类型不同 equals就是false
//        System.out.println(g.equals(c));
//    }
//}
