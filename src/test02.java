import  java.util.Scanner;
public class test02 {

        public static void main(String[] args) {
            int [] b={1,2,3};
            for(int a:b) {

                System.out.println();
            }
            int i=1;
            int n=1;
            while (i <= 10)
            {
                n = n*i;
                i++;
            }
            System.out.println("（foreach)10的阶乘为："+n );
            int number=1;
            int result =1;
            do {
                result *= number;
                number++;
            }while(number <=10);
            System.out.println("(do-while)10的阶乘为：" +n);

            int result1=1;
            for(int number1 = 1;number1<=10;number1++ ) {
                result1 *= number1;
            }

            System.out.println("(for)10的阶乘为："+n);

            //     int [] numbers={10,10,10,10,10};


            //   int result2=1;
            // for (int item : numbers)
            //   {
            //    result2 *=item;

            //  }

            //  System.out.println("(for each:"+n);

            //  int [] numbers1 ={1,2,3,4,5,6,7,8,9,10};
            // for (int i1 =0; i1 < numbers1.length;i++)
            //  {
            //       if (i1 ==3)continue;
            //      System.out.println(numbers[i1]);

            //}

            //       System.out.println("请输入表达式：");
            //       Scanner input = new Scanner(System.in);
            //       String express = "";
            //       express =input.next();
            //       String regex;
            //       String symbol [] = express.split(regex:"\\+");
            //       for(String item:symbol)
            //     {
            //       System.out.println(item);
            // }

        }
    }

