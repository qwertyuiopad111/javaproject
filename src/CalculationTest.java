import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    @Test
    void testOneParam()
    {
        ArrayList<Double> inputs = new ArrayList<Double>();
        inputs.add(5.3);
        Calculation newCal = new Calculation();
        newCal.setInputs(inputs);
        newCal.add();
        double output = newCal.getOutput();

 Assertions.assertEquals(5.6,output,"计算结果不正确！");
    }
    @Test
    void testTwoParams()
    {
        ArrayList<Double> inputs = new ArrayList<Double>();
        inputs.add(5.3);
        inputs.add(8.5);
        Calculation newCal = new Calculation();
        newCal.setInputs(inputs);
        newCal.add();
        double output  = newCal.getOutput();
        System.out.println("计算结果："+output);
        Assertions.assertEquals(13.8,output,"计算结果不正确！");
    }
    @Test
    void testMoreParams()
    {
        ArrayList<Double> inputs = new ArrayList<Double>();
        inputs.add(5.3);
        inputs.add(8.6);
        inputs.add(5.3);
        inputs.add(2.0);
        Calculation newCal = new Calculation();
        newCal.setInputs(inputs);
        newCal.add();
        double output = newCal.getOutput();
        System.out.println("计算结果："+output);
        Assertions.assertEquals(21.2,output,"计算结果不正确！");

    }

}