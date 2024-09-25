import java.util.Scanner;

public class test01 {

    public static void main(String[] args) {
        System.out.println("******");
        System.out.println("SGAVE计算器v1.0");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        String A = sc.nextLine();
        System.out.println("请选择运算符号（+、-、*、/）：");
        String B =sc.nextLine();
        System.out.println("请输入第二个数字：");
        String C =sc.nextLine();

        double D = 0;
        if (B.equals("+"))
        {
            D = Double.parseDouble(A)+Double.parseDouble(C);
        }
        if (B.equals("-"))
        {
            D = Double.parseDouble(A)-Double.parseDouble(C);
        }
        if (B.equals("*"))
        {
            D = Double.parseDouble(A)*Double.parseDouble(C);
        }
        if (B.equals("/"))
        {
            D = Double.parseDouble(A)/Double.parseDouble(C);
        }
        System.out.println("结果是："+ D);
        System.out.println();
        System.out.println("程序结束");
    }

}

