package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


    public class Plus{

        public static void main(String[] args) {
            System.out.println("*************************");
            System.out.println("SGAVE 计算器2.5");
            System.out.println("请输入待计算的表达式");
            String express = new Scanner(System.in).next();
            String symbol[]= express.split("");

            List<String> syAray = Arrays.asList(new String[]{"*", "/", "+", "-"});

            List<String> expressSplit = new ArrayList<String>();

            int last=0;
            for(int i = 0; i < symbol.length;i++)
            {
                String sy = symbol[i];
                if (syAray.contains(sy))
                {
                    if(i==0)

                    {
                        expressSplit.add(0,"0");
                    }
                    else
                    {
                        expressSplit.add(express.substring(last,i));
                    }
                    expressSplit.add(sy);
                    last = i+1;
                }
            }
            if (last!=0)
            {
                expressSplit.add(express.substring(last));

            }
            Plus main = new Plus();
            String result = "";
            while (expressSplit.size()>1)
            {
                String operator = "" ;
                int priority = 0;
                int index = 0;
                for(int i=0;i<expressSplit.size();i++)
                {
                    String sy = expressSplit.get(i);
                    if(syAray.contains(sy))
                    {
                        int pri = getPriority(sy);
                        if(pri>priority)
                        {
                            operator = sy;
                            priority = pri;
                            index = i;
                        }
                    }
                }
                String operand [] = {};
                result = main. calculation(operator,expressSplit.get(index-1),expressSplit.get(index+1));
                expressSplit.remove(index-1);
                expressSplit.remove(index-1);
                expressSplit.remove(index-1);
                expressSplit.add(index-1,result);
                System.out.println(expressSplit);

            };

            System.out.println("Result:"+result);
        }
        /**
         * 计算
         * @param operator
         * @param operand
         * @param operand1
         * @return
         */

        private String calculation(String operator,String operand,String operand1)
        {
            String result = "" ;
            switch(operator)
            {
                case"+":
                    result = sum(operand,operand1);
                    break;
                case"-":
                    result = substract(operand,operand1);
                    break;
                case"*":
                    result =  multiply(operand,operand1);
                     break;
                case"/":
                    result = divide(operand,operand1);
                     break;
            }
            return result;
        }
        private static int getPriority(String operator)
        {
            switch (operator)
            {
                case"+":
                case"-":return 1;
                case"*":
                case"/":return 2;
            }
            return 0;
        }
        private String sum(String op1,String op2)
        {
            double value1 = Double.parseDouble(op1);
            double value2 = Double.parseDouble(op2);
            double result =value1 + value2;
            return result + "";
        }
        private String substract(String op1,String op2)
        {
            double value1 =Double.parseDouble(op1);
            double value2 =Double.parseDouble(op2);
            double result =value1 - value2;
            return result + "";
        }
        private String multiply(String op1,String op2)
        {
            double value1 = Double. parseDouble(op1);
            double value2 = Double.parseDouble(op2);
            double result =value1 * value2;
            return result + "";
        }
        private String divide(String op1,String op2) throws ArithmeticException
        {
            double value1 = Double.parseDouble(op1);
            double value2 = Double.parseDouble(op2);
            double result = 0;

            try
            {
                if (value2==0)
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
            finally
            {
                return result + "";
            }
        }
    }



