import java.util.ArrayList;

public class Calculation{
    public void setInputs(ArrayList<Double> inputs){this.inputs = inputs;}
    public ArrayList<Double> getInputs(){return inputs;}
    public ArrayList<Double> inputs;
    public double getOutput(){return output;}
    public void setOuput(double output){this.output = output;}
    private double output = 0;
    void add()
    {
        this.output = 0;
        for (Double input : inputs)
        {
            output = output + input;
        }
    }
}
