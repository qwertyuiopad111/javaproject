import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Calculator01  extends JFrame {
    JPanel contentPane;
    JTextField outputTextField;
    JTextField memoryTextField;
    
    public static void main(String[] args) {

        new Calculator01();

    }

    Calculator01() {
        setTitle("我的简单计算器v1.0");
        setSize(323, 458);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.contentPane = new JPanel();
        contentPane.setBackground(Color.black);
        this.setContentPane(contentPane);
        contentPane.setLayout(null);

        outputTextField = new JTextField();
        outputTextField.setBackground(Color.cyan);
        outputTextField.setText("0");
        outputTextField.setBounds(10, 10, 296, 56);
        outputTextField.setHorizontalAlignment(SwingConstants.TRAILING);
        outputTextField.setFont(new Font("微软雅黑", Font.BOLD, 36));
        outputTextField.setEditable(false);
        contentPane.add(outputTextField);

        JButton btnMC = new JButton("MC");
        btnMC.setBackground(Color.gray);
        btnMC.setForeground(Color.white);
        btnMC.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnMC.setBounds(10, 80, 66, 40);

        contentPane.add(btnMC);


        JButton buttonMS = new JButton("MS");
        buttonMS.setForeground(Color.WHITE);
        buttonMS.setBackground(Color.GRAY);
        buttonMS.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonMS.setBounds(86, 80, 66, 40);
        contentPane.add(buttonMS);

        JButton btnMR = new JButton("MR");
        btnMR.setForeground(Color.WHITE);
        btnMR.setBackground(Color.GRAY);
        btnMR.setFont(new Font("微软雅黑",Font.BOLD,18));
        btnMR.setBounds(162, 80, 66, 40);
        contentPane.add(btnMR);

        JButton buttonSign = new JButton("+/-");
        buttonSign.setForeground(Color.WHITE);
        buttonSign.setBackground(Color.RED);
        buttonSign.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonSign.setBounds(240, 80, 66, 40);
        contentPane.add(buttonSign);

        JButton btnC = new JButton("C");
        btnC.setForeground(Color.WHITE);
        btnC.setBackground(Color.RED);
        btnC.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnC.setBounds(10, 130, 66, 40);
        contentPane.add(btnC);

        JButton btnCE = new JButton("CE");
        btnCE.setForeground(Color.WHITE);
        btnCE.setBackground(Color.RED);
        btnCE.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnCE.setBounds(86, 130, 66, 40);
        contentPane.add(btnCE);

        JButton buttonDiv = new JButton("/");
        buttonDiv.setForeground(Color.WHITE);
        buttonDiv.setBackground(Color.RED);
        buttonDiv.setFont(new Font("微软雅黑",Font.BOLD,18));
        buttonDiv.setBounds(162, 130, 66, 40);
        contentPane.add(buttonDiv);

        JButton btnMul = new JButton("X");
        btnMul.setForeground(Color.WHITE);
        btnMul.setBackground(Color.RED);
        btnMul.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnMul.setBounds(240, 130, 66, 40);
        contentPane.add(btnMul);

        JButton button7 = new JButton("7");
        button7.setForeground(Color.WHITE);
        button7.setBackground(Color.GRAY);
        button7.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button7.setBounds(10, 180, 66, 40);
        contentPane.add(button7);

        JButton button8 = new JButton("8");
        button8.setForeground(Color.WHITE);
        button8.setBackground(Color.GRAY);
        button8.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button8.setBounds(86, 180, 66, 40);
        contentPane.add(button8);

        JButton button9 = new JButton("9");
        button9.setForeground(Color.WHITE);
        button9.setBackground(Color.GRAY);
        button9.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button9.setBounds(162, 180, 66, 40);
        contentPane.add(button9);

        JButton buttonSub = new JButton("-");
        buttonSub.setForeground(Color.WHITE);
        buttonSub.setBackground(Color.RED);
        buttonSub.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonSub.setBounds(240, 180, 66, 40);
        contentPane.add(buttonSub);

        JButton button4 = new JButton("4");

        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.GRAY);
        button4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button4.setBounds(10, 230, 66, 40);
        contentPane.add(button4);

        JButton button5 = new JButton("5");
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.GRAY);
        button5.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button5.setBounds(86, 230, 66, 40);
        contentPane.add(button5);

        JButton button6 = new JButton("6");
        button6.setForeground(Color.WHITE);
        button6.setBackground(Color.GRAY);
        button6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button6.setBounds(162, 230, 66, 40);
        contentPane.add(button6);

        JButton buttonAdd = new JButton("+");
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setBackground(Color.RED);
        buttonAdd.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonAdd.setBounds(240, 230, 66, 40);
        contentPane.add(buttonAdd);

        JButton button1 = new JButton("1");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.GRAY);
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setBounds(10, 280, 66, 40);
        contentPane.add(button1);

        JButton button2 = new JButton("2");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.GRAY);
        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setBounds(86, 280, 66, 40);
        contentPane.add(button2);

        JButton button3 = new JButton("3");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.GRAY);
        button3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button3.setBounds(162, 280, 66, 40);
        contentPane.add(button3);

        JButton buttonEqual = new JButton("=");
        buttonEqual.setForeground(Color.black);
        buttonEqual.setBackground(Color.YELLOW);
        buttonEqual.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonEqual.setBounds(240, 280, 66, 90);
        outputTextField.setText("100+800*3-330");
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
        contentPane.add(button0);

        JButton buttonDot = new JButton(".");
        buttonDot.setForeground(Color.WHITE);
        buttonDot.setBackground(Color.GRAY);
        buttonDot.setFont(new Font("微软雅黑", Font.BOLD, 18));
        buttonDot.setBounds(162, 330, 66, 40);
        contentPane.add(buttonDot);

        JLabel lblMem = new JLabel("Mem:");
        lblMem.setForeground(Color.WHITE);
        lblMem.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblMem.setBounds(22, 392, 54, 15);
        contentPane.add(lblMem);

        memoryTextField = new JTextField();
        memoryTextField.setEditable(false);
        memoryTextField.setForeground(Color.WHITE);
        memoryTextField.setBackground(Color.MAGENTA);
        memoryTextField.setBounds(86, 386, 220, 27);
        contentPane.add(memoryTextField);
        memoryTextField.setColumns(10);

        setVisible(true);
    }

    void cal(String express)
    {
        String symbols[] = express.split("");
        List<String> syAray = Arrays.asList(new String[]{"*", "/", "+", "-"});
        List<String> expressSplit = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < symbols.length; i++) {
            String sy = symbols[i];
            if (syAray.contains(sy)) {
                if (i == 0) {
                    expressSplit.add(0, "0");
                } else {

                        expressSplit.add(express.substring(last, i));
                    }
                    expressSplit.add(sy);
                    last = i + 1;
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

    /**
     * 计算
     *
     * @param operator
     * @param operand
     * @param operand1
     * @return
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

