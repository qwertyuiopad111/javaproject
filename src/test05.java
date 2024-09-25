public class test05 {

    public static void main(String[] args) {
        int a = 100;
        int b = 0;
        try
        {
            System.out.println(a / b);
        }
        catch(ArithmeticException e)
        {
            System.out.println("发生除零错误：请检查！");
       }
        System.out.println("hello world!");



    }

}