package offerword.singleton_1;

/**
 * @ClassName singleton
 * @Author laixiaoxing
 * @Date 2019/3/31 上午9:35
 * @Description 单例模式
 * 用途：比如说一个大对象，且基本不会更新的，只需要有一个就可以满足应用需求的，创建多个则浪费了空间
 * 例子1 spring里面将bean设置为单例模式的时候，server层服务类，只需要创建一个，就可以到处被调用了
 * 例子2 公共配置文件对象
 * <p>
 * <p>
 * 单例模式又分懒单例（使用时候才创建对象）和饿单例（预先创建好对象）
 * 懒单例的好处就是 在没有用到的时候节省了空间，缺点是增加了复杂度，创建的时候要注意线程安全性
 * @Version 1.0
 */
public class singleton {


}


/**
 * 错误的写法，instance属性和getInstance必须是static的
 * 否则要使用getInstance就要先实例化ErrorSafeSingle ，而ErrorSafeSingle的构造方法又是私有的
 * 无法实例化
 */
class ErrorSafeSingle {

    private ErrorSafeSingle instance = new ErrorSafeSingle();

    private ErrorSafeSingle() {
    }

    public ErrorSafeSingle getInstance() {
        return instance;
    }
}


/**
 * 类加载的时候创建一次 线程安全
 * <p>
 * <p>
 * JVM必须确保一个类在初始化的过程中，如果是多线程需要同时初始化它，仅仅只能允许其中一个线程对其执行初始化操作，其余线程必须等待，只有在活动线程执行完对类的初始化操作之后，才会通知正在等待的其他线程。(所以可以利用静态内部类实现线程安全的单例模式)
 * <p>
 * 何时触发初始化
 * 为一个类型创建一个新的对象实例时（比如new、反射、序列化）
 * 调用一个类型的静态方法时（即在字节码中执行invokestatic指令）
 * 调用一个类型或接口的静态字段，或者对这些静态字段执行赋值操作时（即在字节码中，执行getstatic或者putstatic指令），不过用final修饰的静态字段除外，它被初始化为一个编译时常量表达式
 * 调用JavaAPI中的反射方法时（比如调用java.lang.Class中的方法，或者java.lang.reflect包中其他类的方法）
 * 初始化一个类的派生类时（Java虚拟机规范明确要求初始化一个类时，它的超类必须提前完成初始化操作，接口例外）
 * JVM启动包含main方法的启动类时。
 * <p>
 * <p>
 * 下面这种方法是常用的推荐做法，避免了懒单例的复杂度
 * 静态成员变量在类加载的时候初始化
 * 因为要直接根据类名就可以调用到 ，不和实例绑定
 */
class StaticSafeSingle {

    private static StaticSafeSingle instance = new StaticSafeSingle();

    private StaticSafeSingle() {
    }

    public static StaticSafeSingle getInstance() {
        return instance;
    }
}


/**
 * @Author laixiaoxing
 * @Description 用静态内部类实现线程安全的单例模式  推荐做法
 * 因为只有执行getInstance的时候，才会去调用InstanceHelp.instance字段，这个时候 才会对静态内部类InstanceHelp执行初始化
 * @Date 上午10:11 2019/3/31
 */
class StaticClassSafeSingle {


    private StaticClassSafeSingle() {

    }

    public static StaticClassSafeSingle getInstance() {
        return InstanceHelp.instance;
    }

    /**
     * 静态内部类的形式实现懒单例
     */
    static class InstanceHelp {
        static StaticClassSafeSingle instance = new StaticClassSafeSingle();
    }
}


/**
 * @Author laixiaoxing
 * @Description 懒单例模式 线程不安全的写法
 * 线程不安全的单例子模式，当两个线程同时执行到 if (instance == null)的时候，就会同时进入到调用 new NoSafeSingle();
 * 这样就创建了两个实例
 * @Date 上午9:39 2019/3/31
 */
class NoSafeSingle {

    private NoSafeSingle instance;

    /**
     * 私有构造函数
     */
    private NoSafeSingle() {
    }

    public NoSafeSingle getInstance() {
        if (instance == null) {
            this.instance = new NoSafeSingle();
        }
        return instance;
    }
}


/**
 * @Author laixiaoxing
 * @Description 懒单例模式，双重锁检测
 * 需要加上volatile ，可以避免重排序
 *
 * 重排序 jvm会对指令进行优化 这里的问题在于
 *
 *   instance = new LazySafeSingle(); 这个操作不是原子操作， 里面实际上是分了三步
 *
 *   1.创建LazySafeSingle对象， 给其分配内存（此时instance的值未初始化）
 *   2.初始化LazySafeSingle对象
 *   3.将引用变量instance指向LazySafeSingle的实例的地址
 *
 *   如果按照123的顺序指向，那就没有问题，但是jvm可能会按照 132的顺序执行
 *   但是只要3执行 instance就不等于null了， 但是按132的顺序执行，这个时候其他线程拿到的却是初始化未完成的对象 ，就有问题了
 *
 * 这样就创建了两个实例
 * @Date 上午9:39 2019/3/31
 */
class LazySafeSingle {

    private static volatile LazySafeSingle instance;

    /**
     * 私有构造函数
     */
    private LazySafeSingle() {
    }

    public static LazySafeSingle getInstance() {

        if (instance == null) {
            synchronized (LazySafeSingle.class) {
                if (instance==null){
                    instance = new LazySafeSingle();
                }
            }
        }
        return instance;
    }

}




