import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Double.parseDouble;

public class Calculator03 {
    private JFrame jFrame = new JFrame("计算器");
    private FontUIResource f = new FontUIResource("隶书", 1, 20);
    private FontUIResource f1 = new FontUIResource("楷书", 0, 35);
    private JPanel jPanel = new JPanel();
    private int buttonx = 100;
    private int buttony = 50;
    private int yy = 50;
    private JTextField jTextField1 = new JTextField("0", 30);

    private String str = "";
    private String temp = "";
    private int indexYN = 0;
    private String[] strings = {
            "(", ")", "1/x", "x^2", "x^3", "x^y",
            "x!", "√", "e", "ln", "log", "%",
            "sin", "cos", "tan", "π", "+", "=",
            "7", "8", "9", "0", "-",
            "4", "5", "6", ".", "*",
            "1", "2", "3", "c", "÷"
    };
    private JButton[] buttons = new JButton[33];

    public void loAsi(){
        int tep = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[tep] = new JButton(strings[tep]);
                buttons[tep].setFont(f);
                buttons[tep++].setFocusable(false);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[tep] = new JButton(strings[tep]);
                buttons[tep].setFont(f);
                buttons[tep++].setFocusable(false);
            }
        }
        int lo = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[lo++].setBounds(buttonx * j, yy * (2 + i), buttonx, buttony);
            }
        }
        for (int i = 0; i < 5; i++) {
            buttons[lo++].setBounds(buttonx * i, yy * 4, buttonx, buttony);
        }
        buttons[lo++].setBounds(buttonx * 5, yy * 4, buttonx, buttony * 4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[lo++].setBounds(buttonx * j, yy * (5 + i), buttonx, buttony);
            }
        }
        jTextField1.setBounds(0, yy, 600, yy);
        jTextField1.setFont(f1);
        jTextField1.setHorizontalAlignment(JLabel.RIGHT);
        jTextField1.setEditable(false);
        jTextField1.setBackground(Color.WHITE);

    }
    public void initButton(){//把按钮添加到jPanel中
        this.loAsi();
        jPanel.add(jTextField1);
        for (int i = 0; i < buttons.length; i++) {
            jPanel.add(buttons[i]);
        }
        jPanel.setLayout(null);
    }

    private List<String> zhongZhui(String str) {//把输入的字符串转换成中缀表达式。存入list中
        int index = 0;
        List<String> list = new ArrayList<>();
        do{
            char ch = str.charAt(index);
            if("+-*/^!logsct()".indexOf(str.charAt(index)) >= 0){
                //是操作符，直接添加至list中
                index ++;
                list.add(ch+"");
            }else if (str.charAt(index) == 'e' || str.charAt(index) == 'p'){
                index ++;
                list.add(ch+"");

            } else if("0123456789".indexOf(str.charAt(index)) >= 0){
                //是数字,判断多位数的情况
                String str1 = "";
                while (index < str.length() && "0123456789.".indexOf(str.charAt(index)) >= 0){
                    str1 += str.charAt(index);
                    index ++;
                }
                list.add(str1);

            }
        }while (index < str.length());
        return list;
    }

    public List<String> houZhui(List<String> list){//中缀表达式转换称后缀表达式
        Stack<String> fuZhan = new Stack<>();
        List<String> list2 = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (isNumber(list.get(i))){
                    list2.add(list.get(i));
                } else if (list.get(i).charAt(0) == '('){
                    fuZhan.push(list.get(i));
                } else if (isOperator(list.get(i)) && list.get(i).charAt(0) != '('){
                    if (fuZhan.isEmpty()){
                        fuZhan.push(list.get(i));
                    } else {//符栈不为空
                        if (list.get(i).charAt(0) != ')'){
                            if (adv(fuZhan.peek()) <= adv(list.get(i))){
                                //入栈
                                fuZhan.push(list.get(i));
                            } else {//出栈
                                while (!fuZhan.isEmpty() && !"(".equals(fuZhan.peek())){
                                    if(adv(list.get(i)) <= adv(fuZhan.peek())){
                                        list2.add(fuZhan.pop());
                                    }
                                }
                                if (fuZhan.isEmpty() || fuZhan.peek().charAt(0) == '('){
                                    fuZhan.push(list.get(i));
                                }
                            }
                        } else if (list.get(i).charAt(0) == ')'){
                            while (fuZhan.peek().charAt(0) != '('){
                                list2.add(fuZhan.pop());
                            }
                            fuZhan.pop();
                        }
                    }
                }
            }
            while (!fuZhan.isEmpty()){
                list2.add(fuZhan.pop());
            }
        } else {
            jTextField1.setText("");
        }
        return list2;
    }
    public static boolean isOperator(String op){//判断是否为操作符
        if ("0123456789.ep".indexOf(op.charAt(0)) == -1) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isNumber(String num){//判断是否为操作数
        if ("0123456789ep".indexOf(num.charAt(0)) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public static int adv(String f){//判断操作符的优先级
        int result = 0;
        switch(f) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            case "^":
                result = 3;
                break;
            case "!":
                result = 4;
                break;
            case "g":
                result = 4;
                break;
            case "l":
                result = 4;
                break;
            case "o":
                result = 4;
                break;
            case "s":
                result = 4;
                break;
            case "c":
                result = 4;
                break;
            case "t":
                result = 4;
                break;

        }
        return result;
    }

    public void buttonLister(){//事件监听器
        int tep = 0;
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "(");
                str += "(";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + ")");
                str += ")";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "1/");
                str += "1/";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "^2");
                str += "^2";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "^3");
                str += "^3";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "^");
                str += "^";
            }
        });

        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "!");
                str += "!";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "√");
                str += "g";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "e");
                str += "e";
               str += "2.7182818284590452354";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "ln");
                str += "l";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "log");
                str += "o";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "%");
                str += "*0.01";
            }
        });

        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "sin");
                str += "s";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "cos");
                str += "c";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "tan");
                str += "t";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "π");
                str += "p";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "+");
                str += "+";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (str != ""){
                    estimate();
                    zhanDui();
                } else {
                    str = "";
                }
            }
        });

        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "7");
                str += "7";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "8");
                str += "8";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "9");
                str += "9";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "0");
                str += "0";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "-");
                str += "-";
            }
        });

        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "4");
                str += "4";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "5");
                str += "5";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "6");
                str += "6";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + ".");
                str += ".";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "*");
                str += "*";
            }
        });

        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "1");
                str += "1";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "2");
                str += "2";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "3");
                str += "3";
            }
        });
        buttons[tep++].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                str = "";
                indexYN = 0;
            }
        });
        buttons[tep].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText(jTextField1.getText() + "÷");
                str += "/";
            }
        });
    }

    public void init(){
        this.initButton();
        this.buttonLister();
        jFrame.add(jPanel);
        jFrame.setSize(614, 437);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jFrame.setVisible(true);
    }
    public void estimate(){//判断输入是否错误
        int i = 0;
        if (str.length() == 0){
        }
        if (str.length() == 1){
            //当只有一位字符时，只能是“0123456789ep”中的一个
            if ("0123456789ep".indexOf(str.charAt(0)) == -1){
                jTextField1.setText("输入错误！");
                indexYN = 1;
            }
        }
        if (str.length() > 1){
            for (i = 0; i < str.length() - 1; i++) {
                //1.第一个字符只能为"losctg(0123456789ep"中的一个
                if ("losctg(0123456789ep".indexOf(str.charAt(0)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //2.“+-*/”后面只能是"0123456789losctg(ep"中的一个
                if ("+-*/".indexOf(str.charAt(i)) >= 0 && "0123456789losctg(ep".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //3."."后面只能是“0123456789”中的一个
                if (str.charAt(i) == '.' && "0123456789".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //4."!"后面只能是“+-*/^)”中的一个
                if (str.charAt(i) == '!' && "+-*/^)".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //5."losctg"后面只能是“0123456789(ep”中的一个
                if ("losctg".indexOf(str.charAt(i)) >= 0 && "0123456789(ep".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //6."0"的判断操作
                if (str.charAt(0) == '0' && str.charAt(1) == '0'){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                if (i >= 1 && str.charAt(i) == '0'){
                    //&& str.charAt(0) == '0' && str.charAt(1) == '0'
                    int m = i;
                    int n = i;
                    int is = 0;
                    //1.当0的上一个字符不为"0123456789."时，后一位只能是“+-*/.!^)”中的一个
                    if ("0123456789.".indexOf(str.charAt(m - 1)) == -1 && "+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
                        jTextField1.setText("输入错误！");
                        indexYN = 1;
                    }
                    //2.如果0的上一位为“.”,则后一位只能是“0123456789+-*/.^)”中的一个
                    if (str.charAt(m - 1) == '.' && "0123456789+-*/.^)".indexOf(str.charAt(i + 1)) == -1){
                        jTextField1.setText("输入错误！");
                        indexYN = 1;
                    }
                    n -= 1;
                    while (n > 0){
                        if ("(+-*/^glosct".indexOf(str.charAt(n)) >= 0){
                            break;
                        }
                        if (str.charAt(n) == '.'){
                            is++;
                        }
                        n--;
                    }

                    //3.如果0到上一个运算符之间没有“.”的话，整数位第一个只能是“123456789”，
                    //  且后一位只能是“0123456789+-*/.!^)”中的一个。
                    if ((is == 0 && str.charAt(n) == '0') || "0123456789+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
                        jTextField1.setText("输入错误！");
                        indexYN = 1;
                    }
                    //4.如果0到上一个运算符之间有一个“.”的话,则后一位只能是“0123456789+-*/.^)”中的一个
                    if (is == 1 && "0123456789+-*/.^)".indexOf(str.charAt(i + 1)) == -1){
                        jTextField1.setText("输入错误！");
                        indexYN = 1;
                    }
                    if (is > 1){
                        jTextField1.setText("输入错误！");
                        indexYN = 1;
                    }

                }
                //7."123456789"后面只能是“0123456789+-*/.!^)”中的一个
                if ("123456789".indexOf(str.charAt(i)) >= 0 && "0123456789+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //8."("后面只能是“0123456789locstg()ep”中的一个
                if (str.charAt(i) == '(' && "0123456789locstg()ep".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //9.")"后面只能是“+-*/!^)”中的一个
                if (str.charAt(i) == ')' && "+-*/!^)".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //10.最后一位字符只能是“0123456789!)ep”中的一个
                if ("0123456789!)ep".indexOf(str.charAt(str.length() - 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
                //12.不能有多个“.”
                if (i > 2 && str.charAt(i) == '.'){
                    int n = i - 1;
                    int is = 0;
                    while (n > 0){
                        if ("(+-*/^glosct".indexOf(str.charAt(n)) >= 0){
                            break;
                        }
                        if (str.charAt(n) == '.'){
                            is++;
                        }
                        n--;
                    }
                    if (is > 0){
                        jTextField1.setText("输入错误！");
                        indexYN = 1;
                    }
                }
                //13."ep"后面只能是“+-*/^)”中的一个
                if ("ep".indexOf(str.charAt(i)) >= 0 && "+-*/^)".indexOf(str.charAt(i + 1)) == -1){
                    jTextField1.setText("输入错误！");
                    indexYN = 1;
                }
            }
        }
    }
    public double math(List<String> list2) {//通过后缀表达式进行计算
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < list2.size(); i++) {
            if (isNumber(list2.get(i))) {
                if (list2.get(i).charAt(0) == 'e') {
                    stack.push(String.valueOf(Math.E));
                } else if (list2.get(i).charAt(0) == 'p') {
                    stack.push(String.valueOf(Math.PI));
                } else {
                    stack.push(list2.get(i));
                }
            } else if (isOperator(list2.get(i))) {
                double res = 0;
                if (list2.get(i).equals("+")) {
                    double num2 = parseDouble(stack.pop());
                    double num1 = parseDouble(stack.pop());
                    res = num1 + num2;
                } else if (list2.get(i).equals("-")) {
                    double num2 = parseDouble(stack.pop());
                    double num1 = parseDouble(stack.pop());
                    res = num1 - num2;
                } else if (list2.get(i).equals("*")) {
                    double num2 = parseDouble(stack.pop());
                    double num1 = parseDouble(stack.pop());
                    res = num1 * num2;
                } else if (list2.get(i).equals("/")) {
                    double num2 = parseDouble(stack.pop());
                    double num1 = parseDouble(stack.pop());
                    if (num2 != 0) {
                        res = num1 / num2;
                    } else {
                        jTextField1.setText("除数不能为0");
                        indexYN = 1;
                    }
                } else if (list2.get(i).equals("^")) {
                    double num2 = parseDouble(stack.pop());
                    double num1 = parseDouble(stack.pop());
                    res = Math.pow(num1, num2);
                } else if (list2.get(i).equals("!")) {
                    double num1 = parseDouble(stack.pop());
                    if (num1 == 0 || num1 == 1) {
                        res = 1;
                    } else if (num1 == (int) num1 && num1 > 1) {
                        int d = 1;
                        for (int j = (int) num1; j > 0; j--) {
                            d *= j;
                        }
                        res = d;
                    } else {
                        jTextField1.setText("阶乘必须为自然数");
                        indexYN = 1;
                    }
                } else if (list2.get(i).equals("g")) {
                    double num1 = parseDouble(stack.pop());
                    res = Math.sqrt(num1);
                } else if (list2.get(i).equals("l")) {
                    double num1 = parseDouble(stack.pop());
                    if (num1 > 0) {
                        res = Math.log(num1);
                    } else {
                        jTextField1.setText("ln的x必须大于0");
                        indexYN = 1;
                    }
                } else if (list2.get(i).equals("o")) {
                    double num1 = parseDouble(stack.pop());
                    if (num1 > 0) {
                        res = Math.log(num1) / Math.log(2);
                    } else {
                        jTextField1.setText("log的x必须大于0");
                        indexYN = 1;
                    }
                } else if (list2.get(i).equals("s")) {
                    double num1 = parseDouble(stack.pop());
                    res = Math.sin(num1);
                } else if (list2.get(i).equals("c")) {
                    double num1 = parseDouble(stack.pop());
                    res = Math.cos(num1);
                } else if (list2.get(i).equals("t")) {
                    double num1 = parseDouble(stack.pop());
                    if (Math.cos(num1) != 0) {
                        res = Math.tan(num1);
                    } else {
                        jTextField1.setText("tan的x不能为+-(π/2 + kπ)");
                        indexYN = 1;
                    }
                }
                stack.push("" + res);
            }
        }
        if (indexYN == 0) {
            if (!stack.isEmpty()) {
                eturn Double;
                parseDouble(stack.pop());
            } else {
                return 0;
            }
        } else {
            return -999999;
        }
        return 0;
    }

    public void zhanDui(){//进行计算，并且判断括号是否匹配
        String khao = "";
        int leftkh = 0;
        int rightkh = 0;
        int m = 0;
        //判断括号是否成对
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                khao += '(';
                leftkh++;
            }
            if (str.charAt(i) == ')'){
                khao += ')';
                rightkh++;
            }
        }
        if (leftkh != rightkh){
            jTextField1.setText("输入错误！括号不匹配");
            indexYN = 1;
        }
        if ((leftkh == 0 && rightkh == 0) || ((leftkh == rightkh && leftkh > 0) && khao.charAt(0) == '(' && khao.charAt(khao.length() - 1) == ')')){
            if (indexYN == 0){
                List<String> list1 = zhongZhui(str);
                //System.out.println(list1);
                List<String> list2 = houZhui(list1);
                //System.out.println(list2);
                if (indexYN == 0){
                    if (math(list2) == -999999){
                        jTextField1.setText(jTextField1.getText());
                    } else {
                        jTextField1.setText(String.valueOf(math(list2)));
                    }
                }
            }
        } else {
            jTextField1.setText("输入错误！括号不匹配");
            indexYN = 1;
        }
    }

    public static void main(String[] args) {
        /*
         * 1.在输入过程中每两个数值之间必须有运算符，否则报错.
         * 例如：错误：2ln4(5+8), 2sin2 等
         *      正确：2*ln4*(5+8)， 2*sin2
         * 2.不支持负数，要想得到负数，只能0-x
         * 例如：错误：-2+3*(-2*6)
         *      正确：0-2+3*((0-2)+6)
         * */
        new Calculator03().init();
        //Niumbus风格
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
     /*//Windows风格
     try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
     } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
     } catch (InstantiationException ex) {
         ex.printStackTrace();
     } catch (IllegalAccessException ex) {
         ex.printStackTrace();
     } catch (UnsupportedLookAndFeelException ex) {
         ex.printStackTrace();
     }*/
    /* //Windows经典风格
     try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
     } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
     } catch (InstantiationException ex) {
         ex.printStackTrace();
     } catch (IllegalAccessException ex) {
         ex.printStackTrace();
     } catch (UnsupportedLookAndFeelException ex) {
         ex.printStackTrace();
     }*/
    }

    private class eturn {
    }
}



