import java.util.ArrayList;

public class test06 {

    public static  void main(String[] args){
        ArrayList<Double> inputs = new ArrayList<>();

        inputs.add(10.3);
        inputs.add(12.5);
        inputs.add(17.5);

        Calculation newCal = new Calculation();
        newCal.setInputs(inputs);
        newCal.add();

        double output = newCal.getOutput();
        System.out.println("菜品总价为："+ output +"元");
    }
}
