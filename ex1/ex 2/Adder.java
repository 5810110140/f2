public class Adder{
    private double Val;
    public Adder(){
        Val = 0.0;
    }
    public void add(double x){
        Val = Val + x;
    }
    public void setval(double x) {
        Val = x;        
    }
    public void reset() {
        Val = 0;    
    }
    public double getval() {
        return Val;
    }
    public void addFrom(Adder another){
        Val = Val + another.getval();
    }
}