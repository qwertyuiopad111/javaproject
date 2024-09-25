public class VariableDeclaration
{
    public static void main(String[] args) {


        //整型
        byte a = 20;//定义一个byte类型的变量并赋初值为20
        short b = 10;//定义一个short类型的变量并赋初值为10
        int c = 30;//定义一个int类型的变量并赋初值为30
        long d = 40;//定义一个long类型的变量并赋初值为40
        long sum = a + b + c + d;
        System.out.println("结果："+"20+10+30+40=" + sum);

        //浮点类型
        double lutu = 2348.4;//定义double类型的变量，用于存储单程距离
        int num = 2;//定义int类型的变量，用于存储次数
        float total = (float) (lutu * 2);//定义float类型的变量，用于存储总距离
        System.out.println("结果：" + total + "");

        //字符 类型
        char ca = 'A';//向char类型的a变量赋值为A，A所对应的ASCII值为65
        char cb = 'B';//向char类型的b变量赋值为B，B所对应的ASCII值为66
        System.out.println("A 的 ASCII 值与 B 的 ASCII 值相加结果为："+(ca+cb));

        //隐式转换
        float price1 = 10.9f;//定义牙膏的价格
        double price2 = 5.8;//定义面巾纸的价格
        int num1 = 2;//定义牙膏的数量
        int num2 = 4;//定义面巾纸的数量
        double res = price1 * num1 + price2 * num2;//计算总价
        System.out.println("金额"+res + "元");//输出总价

        //显示转换
        float fPrice1 = 10.9f;
        double fPrice2 = 5.8;
        int fNum1 = 2;
        int fNum2 = 4;
        int fRes2 = (int) (fPrice1 * fNum1 + fPrice2 * fNum2);
        System.out.println("金额" + fRes2 + "元");


    }
}
