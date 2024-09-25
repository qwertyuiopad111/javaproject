import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePad extends JFrame implements ActionListener
{
    JTextArea jta;
    JMenuBar jmb;
    JMenu jml;
    JMenuItem jmi1;
    JMenuItem jmi2;
    JMenuItem jmi3;
    public static  void main(String[] args)
    {
        NotePad np = new NotePad();

    }
    NotePad()
    {
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        this.add(jsp);

        jmb = new JMenuBar();
        jml = new JMenu("文件(F)");
        jmb.add(jml);

        jml.setMnemonic('F');

        jmi1 = new JMenuItem("打开");
        jmi2 = new JMenuItem("保存");
        jmi3 = new JMenuItem("关闭");

        jml.add(jmi1);
        jml.add(jmi2);
        jml.addSeparator();
        jml.add(jmi3);

        jmi1.setActionCommand("open");
        jmi2.setActionCommand("save");
        jmi3.setActionCommand("exit");

        jmi1.addActionListener(this);
        jmi2.addActionListener(this);
        jmi3.addActionListener(this);

        setJMenuBar(jmb);

        setTitle("我的记事本v1.0");
        setSize( 600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("open"))
        {
            System.out.println("打开");
            JFileChooser jfc = new JFileChooser();
            int ret = jfc.showOpenDialog(null);
            if (ret ==JFileChooser.APPROVE_OPTION)
            {
                System.out.println("确定选择文件打开");
                String filename = jfc.getSelectedFile().getAbsolutePath();
                System.out.println(filename);
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(filename);
                    br = new BufferedReader(fr);

                    String s = "";
                    String allcon = "";
                    while ((s = br.readLine()) != null) {
                        allcon += s + "\r\n";

                    }
                    jta.setText(allcon);
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
                finally {
                    try
                    {
                        br.close();
                        fr.close();
                    }
                    catch(IOException exp)
                    {
                        exp.printStackTrace();
                    }
                }

            }
        }
        else if (e.getActionCommand().equals("save"))
        {
            System.out.println("保存");
            System.out.println("打开");
            JFileChooser jfc =new JFileChooser();
            int ret = jfc.showSaveDialog(null);
            if(ret == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("确定选择文件打开");
                String filename = jfc.getSelectedFile().getAbsolutePath();
                System.out.println(filename);
                FileWriter fw =null;
                BufferedWriter bw = null;
                try
                {
                    fw = new FileWriter(filename);
                    bw = new BufferedWriter(fw);

                    bw.write(this.jta.getText());
                }
                catch (IOException ex)
                {
                  ex.printStackTrace();
                }
                finally
                {
                  try
                  {
                      bw.close();
                      fw.close();
                  }
                  catch (IOException exp)
                  {
                   exp.printStackTrace();
                  }
                }
            }
            else if (e.getActionCommand().equals("exit"))
            {
                System.exit(0);
            }
        }
    }

}
