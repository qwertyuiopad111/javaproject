import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

/*JFrame
Java中的GUI程序的基本思路是以JFrame为基础的，他是屏幕上window的对象，能够最大化、最小化、关闭*/
//Swing的三个基本构造快：标签、按钮和文本字段，但是需要安放他们。
/*JFrame类就可以解决这个问题——他是一个容器，允许程序员把其他组件添加到它里面，把他们组织起来，并把他们呈现给用户。在独立于操作系统的Swing组件与实际
运行这些组件的操作系统之间，JFrame起着桥梁作用*/
//在JFrame中有一个CpntentPane，窗口能显示的所有组件都是添加在这个ContentPane中。
//对JFrame添加组件的方式：建例一个Jpanel的这么一个中间容器，把组件添加到容器中，用setContentPane()方法把该容器置为JFrame的类容面板

public class Calculator02  extends JFrame {//子类class继承了父类JFrame，创建了一个午餐构造器，子类可以调用
    JPanel contentPane;
    JTextField outputTextField;
    JTextField memoryTextField;

    public static void main(String[] args) {

        new Calculator02();

    }

    Calculator02() {
        //场景设置——显示窗体
        setTitle("我的简单计算器v1.0");//标题
        setSize(323, 458);//  设置成323x458的一个窗口
        setResizable(false);//且不可拉伸
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口的时候退出程序
        //初始化的方法
        this.contentPane = new JPanel();//调用自己的方法
        contentPane.setBackground(Color.black);
        this.setContentPane(contentPane);
        contentPane.setLayout(null);//取消布局器

        outputTextField = new JTextField();
        outputTextField.setBackground(Color.cyan);
        outputTextField.setText("0");
        outputTextField.setBounds(10, 10, 296, 56);
        outputTextField.setHorizontalAlignment(SwingConstants.TRAILING);
        outputTextField.setFont(new Font("微软雅黑", Font.BOLD, 36));
        outputTextField.setEditable(false);
        contentPane.add(outputTextField);

        JButton btnMC = new JButton("MC");//放置MC
        btnMC.setBackground(Color.gray);
        btnMC.setForeground(Color.white);
        btnMC.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnMC.setBounds(10, 80, 66, 40);
        btnMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {memoryTextField.setText("0");}
        });

        contentPane.add(btnMC);//向contentPane中添加组件”btnMC“

        /*actionPerformed方法
        它在Java的ActionListener接口中被定义。其主要用途是响应用户对图性用户界面（GUI）组件进行交互，例如点击按钮会触发对应的操作事件，进而导致该方法的调用

         */



        JButton buttonMS = new JButton("MS");//放置MS
        buttonMS.setForeground(Color.WHITE);
        buttonMS.setBackground(Color.GRAY);
        buttonMS.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonMS.setBounds(86, 80, 66, 40);
        buttonMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal(outputTextField.getText());
                memoryTextField.setText(outputTextField.getText());

            }
        });
        contentPane.add(buttonMS);

        JButton btnMR = new JButton("MR");//放置MR
        btnMR.setForeground(Color.WHITE);
        btnMR.setBackground(Color.GRAY);
        btnMR.setFont(new Font("微软雅黑",Font.BOLD,18));
        btnMR.setBounds(162, 80, 66, 40);
        btnMR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextField.setText(outputTextField.getText()+memoryTextField.getText());

            }
        });
        contentPane.add(btnMR);

        JButton buttonSign = new JButton("+/-");
        buttonSign.setForeground(Color.WHITE);
        buttonSign.setBackground(Color.RED);
        buttonSign.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonSign.setBounds(240, 80, 66, 40);
        buttonSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(outputTextField.getText().equals("0"))
                {
                    outputTextField.setText("-");
                }
                else {
                    String str =  outputTextField.getText();
                    int index = str.indexOf('-');
                    if (index==0)
                    {
                        String subStr = str .substring(1);
                        outputTextField.setText(subStr);
                    }
                    else
                    {
                     outputTextField.setText("-"+outputTextField.getText());
                    }
                }
            }
        });
        contentPane.add(buttonSign);

        JButton btnC = new JButton("C");//放置C，消除所有输入
        btnC.setForeground(Color.WHITE);
        btnC.setBackground(Color.RED);
        btnC.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnC.setBounds(10, 130, 66, 40);
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextField.setText("0");
            }
        });
        contentPane.add(btnC);

        JButton btnCE = new JButton("CE");//放置CE，消除当前输入
        btnCE.setForeground(Color.WHITE);
        btnCE.setBackground(Color.RED);
        btnCE.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnCE.setBounds(86, 130, 66, 40);
        btnCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextField.setText("0");
                memoryTextField.setText("0");
            }
        });
        contentPane.add(btnCE);

        JButton buttonDiv = new JButton("/");//放置 /
        buttonDiv.setForeground(Color.WHITE);
        buttonDiv.setBackground(Color.RED);
        buttonDiv.setFont(new Font("微软雅黑",Font.BOLD,18));
        buttonDiv.setBounds(162, 130, 66, 40);
        buttonDiv.addActionListener(e -> buttonPressed(e));
        contentPane.add(buttonDiv);

        JButton btnMul = new JButton("*");//放置 *
        btnMul.setForeground(Color.WHITE);
        btnMul.setBackground(Color.RED);
        btnMul.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnMul.setBounds(240, 130, 66, 40);
        btnMul.addActionListener(e -> buttonPressed(e));
        contentPane.add(btnMul);

        JButton button7 = new JButton("7");//放置数字7
        button7.setForeground(Color.WHITE);
        button7.setBackground(Color.GRAY);
        button7.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button7.setBounds(10, 180, 66, 40);
        button7.addActionListener(e -> buttonPressed(e));
        contentPane.add(button7);

        JButton button8 = new JButton("8");//放置数字8
        button8.setForeground(Color.WHITE);
        button8.setBackground(Color.GRAY);
        button8.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button8.setBounds(86, 180, 66, 40);
        button8.addActionListener(e -> buttonPressed(e));
        contentPane.add(button8);

        JButton button9 = new JButton("9");//放置数字9
        button9.setForeground(Color.WHITE);
        button9.setBackground(Color.GRAY);
        button9.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button9.setBounds(162, 180, 66, 40);
        button9.addActionListener(e -> buttonPressed(e));
        contentPane.add(button9);

        JButton buttonSub = new JButton("-");//放置 -
        buttonSub.setForeground(Color.WHITE);
        buttonSub.setBackground(Color.RED);
        buttonSub.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonSub.setBounds(240, 180, 66, 40);
        buttonSub.addActionListener(e -> buttonPressed(e));
        contentPane.add(buttonSub);

        JButton button4 = new JButton("4");//放置数字4

        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.GRAY);
        button4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button4.setBounds(10, 230, 66, 40);
        button4.addActionListener(e -> buttonPressed(e));
        contentPane.add(button4);

        JButton button5 = new JButton("5");//放置数字5
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.GRAY);
        button5.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button5.setBounds(86, 230, 66, 40);
        button5.addActionListener(e -> buttonPressed(e));
        contentPane.add(button5);

        JButton button6 = new JButton("6");//放置数字6
        button6.setForeground(Color.WHITE);
        button6.setBackground(Color.GRAY);
        button6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button6.setBounds(162, 230, 66, 40);
        button6.addActionListener(e -> buttonPressed(e));
        contentPane.add(button6);

        JButton buttonAdd = new JButton("+");//放置 +
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setBackground(Color.RED);
        buttonAdd.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonAdd.setBounds(240, 230, 66, 40);
        buttonAdd.addActionListener(e -> buttonPressed(e));
        contentPane.add(buttonAdd);

        JButton button1 = new JButton("1");//放置数字1
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.GRAY);
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setBounds(10, 280, 66, 40);
        button1.addActionListener(e -> buttonPressed(e));
        contentPane.add(button1);

        JButton button2 = new JButton("2");//放置数字2
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.GRAY);
        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setBounds(86, 280, 66, 40);
        button2.addActionListener(e -> buttonPressed(e));
        contentPane.add(button2);

        JButton button3 = new JButton("3");//放置数字3
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.GRAY);
        button3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button3.setBounds(162, 280, 66, 40);
        button3.addActionListener(e -> buttonPressed(e));
        contentPane.add(button3);

        JButton buttonEqual = new JButton("=");//放置 =
        buttonEqual.setForeground(Color.black);
        buttonEqual.setBackground(Color.YELLOW);
        buttonEqual.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonEqual.setBounds(240, 280, 66, 90);

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cal(outputTextField.getText());
            }
        });
        contentPane.add(buttonEqual);


        JButton button0 = new JButton("0");
        button0.setForeground(Color.WHITE);
        button0.setBackground(Color.GRAY);
        button0.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button0.setBounds(10, 330, 142, 40);
        button0.addActionListener(e->buttonPressed(e));
        contentPane.add(button0);

        JButton buttonDot = new JButton(".");//放置 .
        buttonDot.setForeground(Color.WHITE);
        buttonDot.setBackground(Color.GRAY);
        buttonDot.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonDot.setBounds(162, 330, 66, 40);
        buttonDot.addActionListener(e -> buttonPressed(e));
        contentPane.add(buttonDot);

        JLabel lblMem = new JLabel("Mem:");
        lblMem.setForeground(Color.WHITE);
        lblMem.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblMem.setBounds(22, 392, 54, 15);
        contentPane.add(lblMem);

        memoryTextField = new JTextField();//添加表达式文本框，用以输入计算公式
        memoryTextField.setEditable(false);
        memoryTextField.setForeground(Color.WHITE);
        memoryTextField.setBackground(Color.MAGENTA);
        memoryTextField.setBounds(86, 386, 220, 27);
        contentPane.add(memoryTextField);
        memoryTextField.setColumns(10);

        setVisible(true);//设置窗口可见性
    }
    void buttonPressed(ActionEvent e)
    {
        JButton btn = (JButton) e.getSource();//获取事件源对象，其实就是按钮本身
        if (outputTextField.getText().equals("0"))
        {
            outputTextField.setText(btn.getText());
        }
        else
        {
            outputTextField.setText(outputTextField.getText()+ btn.getText());
        }
    }

    void cal(String express)
    {
        String symbols[] = express.split("");
        List<String> syAray = Arrays.asList(new String[]{"*", "/", "+", "-"});//运算符集合
        List<String> expressSplit = new ArrayList<>();
        int last = 0;//最后一次命中符号位置
        for (int i = 0; i < symbols.length; i++) {
            String sy = symbols[i];
            if (syAray.contains(sy)) {
                if (i == 0) {//第一个符号位，补0
                    expressSplit.add(0, "0");
                }
                else
                {

                    expressSplit.add(express.substring(last, i));
                }
                expressSplit.add(sy);
                last = i + 1;//跳过符号
            }
        }
        if (last != 0) {
            expressSplit.add(express.substring(last));
        }

        String result  = "";
        while(expressSplit.size()>1){


            String operator = "";
            int priority = 0;
            int index = 0;
            for (int i = 0; i < expressSplit.size(); i++) {
                String sy = expressSplit.get(i);
                if (syAray.contains(sy)) {
                    int pri = getPriority(sy);
                    if (pri > priority) {
                        operator = sy;
                        priority = pri;
                        index = i;
                    }
                }
            }
            String operand[] = {};
            result  = calculation(operator, expressSplit.get(index - 1), expressSplit.get(index + 1));
            expressSplit.remove(index - 1);
            expressSplit.remove(index - 1);
            expressSplit.remove(index - 1);
            expressSplit.add(index-1,result);
            System.out.println(expressSplit);
        };
        System.out.println("Result:" + result);
        outputTextField.setText(result);
    }
    //运算功能的实现
    /**
     * 计算
     *
     * @param operator
     * @param operand
     * @param operand1
     * @return
     */


    /*private
    是封装的一种，其实像public、protected都是封装的一种。
    private修饰符只能在这个类中被访问
     */

    private String calculation(String operator, String operand, String operand1) {
        String result = "";
        switch (operator) {
            case "+":
                result = sum(operand, operand1);
                break;
            case "-":
                result = substract(operand, operand1);
                break;
            case "*":
                result = multiply(operand, operand1);
                break;
            case "/":
                result = divide(operand, operand1);
                break;
        }
        return result;
    }

    private static int getPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return 0;
    }

    /**
     * 加法
     *
     * @param operand1
     * @param operand2
     * @return
     * @throws Exception
     */
    private String sum(String operand1, String operand2) {
        System.out.println("加法");
        double a = Double.parseDouble(operand1);
        double b = Double.parseDouble(operand2);
        return "" + (a + b);
    }

    /**
     * 减法
     *
     * @param operand1
     * @param operand2
     * @return
     */
    private String substract(String operand1, String operand2) {
        System.out.println("减法");
        double a = Double.parseDouble(operand1);
        double b = Double.parseDouble(operand2);
        return "" + (a - b);
    }

    /**
     * 乘法
     *
     * @param operand1
     * @param operand2
     * @return
     */
    private String multiply(String operand1, String operand2) {
        System.out.println("乘法");
        double a = Double.parseDouble(operand1);
        double b = Double.parseDouble(operand2);
        return "" + (a * b);
    }

    /**
     * 除法
     *
     * @param operand1
     * @param operand2
     * @return
     */
    private String divide(String operand1, String operand2) throws ArithmeticException {
        System.out.println("除法");
        String r = "0";
        double x = 0;
        double a = Double.parseDouble(operand1);
        double b = Double.parseDouble(operand2);
        try {
            if (b == 0) {
                throw new ArithmeticException("除0 异常");
            }
            r = "" + (a / b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            return r;
        }

    }
}
/*try块：包含可能抛出的代码，当发生异常时，程序会跳转到catch块或finally块，或者执行正常的流程。
catch块：当try块中的代码抛出异常时，而catch块就开始工作。
finally块：无论是否发生异常，finally块中的代码都会执行。它通常用于释放资源、清理操作或确保一定会执行的代码。
 */
