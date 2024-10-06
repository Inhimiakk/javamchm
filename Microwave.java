public class Microwave extends Appliance{
    public Microwave(int power, double size) {
        super(power, size, "микроволновочка");
    }

    public double getPrice() {
        if (getPower() > 1000) {
            return 1000 + getSize() * 500;
        }
        else {
            return (1000 + getSize() * 500)*0.9;
        }
    }
    
}
