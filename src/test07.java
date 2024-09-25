import java.io.*;
import java.util.Scanner;

public class test07 {
    public static  void main(String[] args)
    {

        //文件的字节输入流
//        File file = new File("j:"+File.separator+"demo.txt.txt");
//        try
//        {
//            FileInputStream input = new FileInputStream(file);
//            byte[] b = new byte[1024];
//            int len = input.read(b);
//            System.out.println(new String(b,0,len));
//            input.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }

        //文件的字节输出流
//        File file = new File("j:"+File.separator+"demo.txt.txt");
//        try
//        {
//            FileOutputStream output =  new FileOutputStream(file,true);
//            String str = "hello world !";
//            byte[] b = str.getBytes();
//            output.write(b);
//            output.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }

        //字符输入流
//         File file = new File("j:"+File.separator+"demo.txt.txt");
//        try
//        {
//            FileReader input = new FileReader(file);
//                      char[] c =new char[1024];
//            int len = input.read(c);
//            System.out.println(new String(c,0,len));
//            input.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }

        //文件的字符输出流
//        File file = new File("j:"+File.separator+"demo.txt.txt");
//        try
//        {
//            FileWriter output = new FileWriter(file,true);
//            String str = "知许解夏，长长久久";
//            output.write(str);
//            output.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请输入姓名：");
//        try
//        {
//            String str = bufReader.readLine();
//            System.out.println("您的姓名为："+str);
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//       }
//        Scanner sc =new Scanner(System.in);
//        if(sc.hasNext())
//        {
//            System.out.println(sc.nextInt());
//        }
        //格式化输入和输出
        /*
        File file = new File("j:"+File.separator+"demo.txt.txt");
        try
        {
            DataOutputStream dis = new DataOutputStream(new FileOutputStream(file));
            dis.writeInt(100);
            dis.close();
            DataInputStream dos = new DataInputStream(new FileInputStream(file));
            int value = dos.readInt();
            System.out.println(value);
            dis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/
    }
}
