package option;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

/**
 * @ClassName testOption
 * @Author laixiaoxing
 * @Date 2019/3/26 上午11:03
 * @Description java的空对象封装类测试
 * @Version 1.0
 */
public class testOption {

    public static void main(String[] args) throws Exception {

        //作用是将对象封装成Optional对象
        //如果放进去的是null, 会抛出空指针异常
                Optional.of(null);

        //作用是将对象封装成Optional对象
        //如果放进去的是null, 会返回空的option对象 empty 还是单例的
        //具体为 private static final Optional<?> EMPTY = new Optional<>();
                Optional.ofNullable(null);

                //如果是null 则抛RuntimeException异常或者其子异常
                Optional.ofNullable(null).orElseThrow(() -> new RuntimeException());

                //如果是空 给予默认值
                Optional.ofNullable(null).orElse("默认值");


                Optional.ofNullable(null).ifPresent((value) -> {
                    System.out.println("如果值不为空则" + value);
                });
                Optional.ofNullable("我是值").ifPresent((value) -> {
                    System.out.println("如果值不为空则" + value);
                });

        //重点中的重点 连续字段取值的时候判空
        //如下的情况
        TestNull testNull1 = new TestNull();
                TestNull testNullA = new TestNull();
                testNullA.setBigDecimal(BigDecimal.TEN);
          testNull1.setTestNull(testNullA);

        if (testNull1 != null) {
            TestNull testNull2 = testNull1.getTestNull();
            if (testNull2 != null) {
                BigDecimal result = testNull2.getBigDecimal();
                if (testNull2.getBigDecimal() != null) {
                    BigDecimal result2 = result.divide(BigDecimal.TEN);
                    System.out.println("最终结果1:" + result);
                    System.out.println("最终结果2:" + result2);
                }
            }
        }

        //不能说写成如下 ，如果有null则空指针异常了
                testNull1.getTestNull().getBigDecimal().divide(BigDecimal.TEN);


        BigDecimal result3 = Optional.ofNullable(testNull1).map(t1 -> t1.getTestNull()).map(t2 -> t2.getBigDecimal())
                .map(bigDecimal -> bigDecimal.divide(BigDecimal.TEN)).orElse(BigDecimal.ZERO);
        System.out.println("最终结果:" + result3);


        //使用flatmap 该函数的返回值必须为option


        BigDecimal result4 = Optional.ofNullable(testNull1).flatMap(t1 -> Optional.of(t1.getTestNull())).flatMap(
                t2 -> Optional.of(t2.getBigDecimal())
                        .flatMap(bigDecimal -> Optional.of(bigDecimal.divide(BigDecimal.TEN)))).orElse(BigDecimal.ZERO);
        System.out.println("最终结果:" + result3);

        //看起来flatmap好像是麻烦了很多 但是
        //如果是对象属性已经被option包起来了的话
        Address address = new Address(null);
        Person person = new Person(Optional.of(address));
        Optional.ofNullable(person).flatMap(Person::getAddress).
                flatMap(Address::getValidFrom).
                isPresent();


        //注意 属性必须为final
        TestNullOp testNullOp=new TestNullOp(null,null);
        Optional.ofNullable(testNullOp).flatMap(TestNullOp::getTestNull).
                flatMap(TestNullOp::getBigDecimal).
                isPresent();
    }


    static class TestNull {

        private BigDecimal bigDecimal;

        private TestNull testNull;

        public BigDecimal getBigDecimal() {
            return bigDecimal;
        }

        public void setBigDecimal(BigDecimal bigDecimal) {
            this.bigDecimal = bigDecimal;
        }

        public TestNull getTestNull() {
            return testNull;
        }

        public void setTestNull(TestNull testNull) {
            this.testNull = testNull;
        }
    }


    static class TestNullOp {

        private final Optional<BigDecimal> bigDecimal;

        private  final Optional<TestNullOp> testNull;

        TestNullOp(Optional<BigDecimal> bigDecimal, Optional<TestNullOp> testNull) {
            this.bigDecimal = bigDecimal;
            this.testNull = testNull;
        }

        public Optional<BigDecimal> getBigDecimal() {
            return bigDecimal;
        }

        public Optional<TestNullOp> getTestNull() {
            return testNull;
        }
    }


    static class Person {

        private final Optional<Address> address;

        Person(Optional<Address> address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return address;
        }


    }

    static class Address {
        private final Optional<Instant> validFrom;

        Address(Optional<Instant> validFrom) {
            this.validFrom = validFrom;
        }

        public Optional<Instant> getValidFrom() {
            return validFrom;
        }

        //...
    }

}

