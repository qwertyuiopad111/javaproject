package com.company;

import java.util.function.DoubleBinaryOperator;

public class SimpleMethod02 {

    public static void main(String[] args) {

        SimpleMethod02 simpleArray = new SimpleMethod02();
        System.out.println("加法:"+ simpleArray.sum("1", "1"));
        System.out.println("减法:"+ simpleArray.substract("2","1"));
        System.out.println("乘法:"+ simpleArray.multiply("100","10"));
        System.out.println("除法:"+ simpleArray.divide("100","0"));

    }

    private String sum(String op1, String op2)
    {
        double value1 = Double.parseDouble(op1);
        double value2 = Double.parseDouble(op2);
        double result = value1 + value2;

        return  result + "";

    }
    private String substract(String op1, String op2)
    {
        double value1 = Double.parseDouble(op1);
        double value2 = Double.parseDouble(op2);
        double result = value1 - value2;

        return  result + "";

    }
    private String multiply(String op1, String op2)
    {
        double value1 = Double.parseDouble(op1);
        double value2 = Double.parseDouble(op2);
        double result = value1 * value2;

        return  result + "";
    }
    private String divide(String op1, String op2) throws ArithmeticException
    {
        double value1 = Double.parseDouble(op1);
        double value2 = Double.parseDouble(op2);
        double result = 0;


        try
        {
            if (value2 == 0)
            {
                throw new ArithmeticException("除零异常");
            }
            result = value1 / value2;

        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            return result + "";
        }
    }
}


