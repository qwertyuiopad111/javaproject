package com.company;

public class SimpleMethod01 {

    public static void main(String[] args){

        SimpleMethod01 simpleArray = new SimpleMethod01();
        simpleArray.sum("1","1");
        simpleArray.substract("2","1");
        simpleArray.multiply("100","10");
        simpleArray.divide("100","25");

    }

    private String sum(String op1,String op2)
    {

        System.out.println("加法");
        return"";

    }
    private String substract(String op1,String op2)
    {

        System.out.println("减法");
        return"";

    }
    private String multiply(String op1,String op2)
    {

        System.out.println("乘法");
        return"";

    }
    private String divide(String op1,String op2)
    {

        System.out.println("除法");
        return"";
    }
}
