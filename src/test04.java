import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;

public class test04 {

    public static void main(String[] args) {
        double[] score1 = {99, 100, 98.5, 96.5, 72};
        double[] score2 = new double[5];
        score2[0] = 99;
        score2[1] = 100;
        score2[2] = 98.5;
        score2[3] = 96.5;
        score2[4] = 72;
        double[] score3 = {99, 96.5, 98.5, 100, 72};

        if (Arrays.equals(score1, score2)) {
            System.out.println("score1数组与score2数组相等！");
        } else {
            System.out.println("score1数组与score2数组不相等！");
        }
        if (Arrays.equals(score1, score2)) {
            System.out.println("score1数组与score3数组相等！");
        } else {
            System.out.println("score1数组与score3数组不相等！");
        }
        Double[] score = {99.5, 100.0, 98.0, 97.5, 100.0, 95.0, 85.5, 100.0};
        double[] score4 = {99.5, 100.0, 98.0, 97.5, 100.0, 95.0, 85.5, 100.0};

        Arrays.sort(score, Collections.reverseOrder());

        System.out.println(score);


        System.out.println(Arrays.toString(score));

        int index1 = Arrays.binarySearch(score4, 100);
        int index2 = Arrays.binarySearch(score4, 60);
        System.out.println("查找到100的位置是:" + index1);
        System.out.println("查找到60的位置是:" + index2);

        Employee[] emops
                =
                {
                        new Employee("张三", "RD"),
                        new Employee("李四", "PD")
                };
        System.out.println(Arrays.toString(emops));
    }
}
    class Employee
    {
        String username;
        String dempartment;

        Employee(String username, String dempartment)
        {
            this.username = username;
            this.dempartment = dempartment;
        }

        @Override
        public String toString() {

            return "姓名:" + username + "  部门:" +dempartment;
        }
    }
