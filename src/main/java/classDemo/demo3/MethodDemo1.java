package classDemo.demo3;

import java.lang.reflect.Method;

public class MethodDemo1 {
    public static void main(String[] args) {
        //要获取print(int ，int) 方法
        //要获取一个方法，就是要获取类的信息，获取类的信息，首先要获取类的类类型

        A a1 = new A();
        Class c = a1.getClass();
        ///获取方法：名称和参数列表来决定
        //getMethod 获取的是public方法
        //getDelcareMethod自己声明的方法
        try {
            Method m = c.getMethod("print", int.class, int.class);
            //此时获取到了method的方法的对象
            //方法的反射操作：是用Method对象来进行方法的调用操作
            //方法如果没有返回值则返回null,如果有返回值 则返回具体的返回值
            Object o = m.invoke(a1, 1, 2);
            //等同于
            a1.print(1, 2);

            //通过反射调用方法的私有对象
            //先获取声明的所有方法
            Method m2 = c.getDeclaredMethod("print",int.class);
            System.out.println("开始获取方法");
            System.out.println(m2.getName());
            System.out.println("参数列表为");
            for (Class<?> aClass : m2.getParameterTypes()) {
                System.out.println(aClass.getName());
            }
            System.out.println("调用私有方法");
//            m2.invoke(a1, 1);
            //会报异常
            //java.lang.IllegalAccessException: Class classDemo.demo3.MethodDemo1 can not access a member of class
            // classDemo.demo3.A with modifiers "private"
            //但是手动将该方法改为公有的即可
            m2.setAccessible(Boolean.TRUE);
            m2.invoke(a1, 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class A {

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }

    private void print(int a) {
        System.out.println(a);
    }


}