public class test03 {

    public static void main(String[] args) {

        String str = "Hello world!";
        String str2;
        str2 = "Hello world!";
        System.out.println("直接定义字符串:" + str);

        String str1 = new String("hello sgave" );
        String str3 = new String(str1);
        System.out.println("使用String类："+ str3);

        char a []={'H','e','l','l','o'};
        String sChar=new String(a,1,2);
        System.out.println(sChar);

        String str4 = "welcome to" + " sgave!"
                +"欢迎来到" + "sgave"+"大数据项目组。";
        System.out.println(str4);
        String cn = "中国";

        System.out.println(cn.concat("上海").concat("闵行").concat("梅陇镇"));
        System.out.println(cn+cn.length());

        String str5 = "123sGave Group";
        System.out.println(str5.toLowerCase());
        System.out.println(str5.toUpperCase());
        System.out.println(str5);

        for(String item : "account? and uu=? or n=?".split("and|or"))
        {
            System.out.println(item);
        }

        String str6 = "Hello, World! Hello, Java!";
        System.out.println(str6.replace("Hello","Hi"));
        System.out.println(str6.replaceFirst("Hello","Hi"));
        System.out.println(str6.replaceAll("Hello","Hi"));

        String str7 = "Hello World!";
        String str8 = new String("Hello World!");

        if (str7.equals(str8))
        {
            System.out.println("相等!");
        }
        else
        {
            System.out.println("不相等!");
        }
        String str9 = "zhixujieixa,changchangjiujiu";
        String str10 = new String("zhixujiexia,changchangjiujiu");
        System.out.println("合法！");




    }
}
