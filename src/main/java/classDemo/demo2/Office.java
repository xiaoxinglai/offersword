package classDemo.demo2;

public class Office {
    public static void main(String[] args) {
//        if ("Word".equals(args[0])){
//           Word w=new  Word();
//           w.start();
//        }
//
//        if ("Excel".equals(args[0])){
//            Excel e=new  Excel();
//            e.start();
//        }

        try {
            Class c=Class.forName("classDemo.demo2.Word");
            Class c2=Class.forName("classDemo.demo2.Excel");
        }catch (Exception ex){

        }



    }
}
