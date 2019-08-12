//package classDemo.demo4;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//
//public class MethodDemo4 {
//    public static void main(String[] args) {
//        ArrayList list=new ArrayList();
//
//        ArrayList<String> list1=new ArrayList<String>();
//        list1.add("hello");
//       // list1.add(2);  //直接放是错误的 会报错 因为编译时限制了类型是String
//
//        Class c1=list.getClass();
//        Class c2=list1.getClass();
//        System.out.println(c1==c2);
//
//        //c1==c2 编译之后集合的泛型是去泛型化的
//        try {
//            Method m=c2.getMethod("add",Object.class);
//            m.invoke(list1,2); //绕过泛型的限制 将2这个整型放进去了 ，说明在运行时候 去没有限制的
//            System.out.println(list1.size());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
