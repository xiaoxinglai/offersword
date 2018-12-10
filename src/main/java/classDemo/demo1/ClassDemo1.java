package classDemo.demo1;

public class ClassDemo1 {
    public static void main(String[] args) {

        //Foo的实例对象
        Foo foo1 = new Foo(1);

        //只有jvm能创建Class类的实例对象  java.lang.Class
        // 这个类的构造方法是私有的
        //任何一个类都Class类的实例对象
        //有三种表示方法


        //第一种表示方式
        //实际上在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种表达方式，已知该类的对象
        //通过该类的对象的getClass方法
        Class c2 = foo1.getClass();

        // c1 c2表示了Foo类的类类型（class type）

//       类也是对象，是Class类的实例对象
//                这个对象我们称为该类的类类型

        //c1 c2均代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2); //输出为true

        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("classDemo.demo1.Foo"); //如果不是根目录 要写类的全路径
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println(c2 == c3); //输出仍然是true

        //通过Class 去创建对象
        //通过该类的类类型创建该类的对象实例

        try {

            Foo foo = (Foo) c1.newInstance(); //注意！这种需要有无参构造方法
           //如果没有无参构造方法 报错ava.lang.Class.newInstance(Class.java:427)
            //  .NoSuchMethodException
        } catch (InstantiationException ex) {

            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

    }

}

class Foo {
    public Foo(int a) {
    }
}

